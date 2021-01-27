package org.product.facade.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.common.base.WebErrorFactory;
import org.product.domain.CheckStockParam;
import org.product.domain.CreateProductParam;
import org.product.dto.DeductStockResultDto;
import org.product.entity.ProductInfoEntity;
import org.product.entity.StockRecordEntity;
import org.product.facade.ProductInfoFacade;
import org.product.service.ProductInfoService;
import org.product.service.StockRecordService;
import org.product.support.RedisScriptSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ProductInfoFacadeImpl
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午3:19
 */
@Service
public class ProductInfoFacadeImpl implements ProductInfoFacade {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private StockRecordService stockRecordService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisScriptSupport redisScriptSupport;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveProduct(CreateProductParam param) {
        if (ObjectUtils.isEmpty(param.getStock()) || param.getStock() < 1){
            throw new WebErrorFactory("新增产品,库存必须大于0");
        }
        if (StringUtils.isEmpty(param.getProductName())){
            throw new WebErrorFactory("新增产品,产品名称不能为空");
        }
        String productCode = UUID.randomUUID().toString().replace("-", "");
        productInfoService.insert(ProductInfoEntity.builder()
                .productName(param.getProductName())
                .productCode(productCode)
                .productStatus(0)
                .stock(param.getStock())
                .build());
        redisTemplate.opsForValue().set(String.format("STOCK:STOCKNUM_%s", productCode),String.valueOf(param.getStock()));
        return productCode;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String checkStock(CheckStockParam param) {
        String batchNo = UUID.randomUUID().toString().replace("-", "");
        Long stockRecordId = saveStockRecord(batchNo, param.getOrderCode(), param.getProductCode(), 1);
        ProductInfoEntity productInfoEntity = productInfoService.getOne(new QueryWrapper<ProductInfoEntity>().lambda()
                .eq(ProductInfoEntity::getProductCode, param.getProductCode())
        );
        //调用扣库存脚本
        List<String> keyList = new ArrayList();
        //总库存
        keyList.add(String.format("STOCK:STOCKNUM_%s", param.getProductCode()));
        keyList.add(String.format("STOCK:STOCK_BATCHNO_%s", batchNo));
        DeductStockResultDto deductStockResultDto = null;
        boolean fallBack = false;
        boolean demotion = false;
        try{
            try{
                JSONObject result = (JSONObject) redisScriptSupport.execute(keyList,1,batchNo,0);
                if (!ObjectUtils.isEmpty(result)){
                    deductStockResultDto = result.toJavaObject(DeductStockResultDto.class);
                    if(!ObjectUtils.isEmpty(deductStockResultDto)&&!ObjectUtils.isEmpty(deductStockResultDto.getErrno())&&deductStockResultDto.getErrno()<1){
                        //-2:商品不存在,-1:库存不足,0:重复执行,1:成功
                        throw new WebErrorFactory(deductStockResultDto.getMsg());
                    }
                }
            }catch (Exception e){
                //根据开关,决定是否降级为数据库否则就走回滚
                //降为数据库,直接for update
                if (demotion){
                    deductStockResultDto = getDbDeductStock(productInfoEntity.getId());
                }else {
                    throw new WebErrorFactory(e.getMessage());
                }
            }
            updateStockRecord(stockRecordId,deductStockResultDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
            //发送回滚流水
            redisTemplate.opsForList().leftPush("STOCK:STOCK_FALLBACK",batchNo);
            throw new WebErrorFactory(e.getMessage());
        }
        return batchNo;
    }

    private DeductStockResultDto getDbDeductStock(Long id) {
        ProductInfoEntity productInfoEntity = productInfoService.getForUpdate(id);
        DeductStockResultDto deductStockResultDto = new DeductStockResultDto();
        deductStockResultDto.setNum(1);
        deductStockResultDto.setVersion(2);
        productInfoEntity.setStock(productInfoEntity.getStock() - 1);
        productInfoService.updateByDataId(productInfoEntity);
        deductStockResultDto.setStock(productInfoEntity.getStock());
        return deductStockResultDto;
    }

    private void  updateStockRecord(Long stockRecordId, DeductStockResultDto deductStockResultDto) {
        if (ObjectUtils.isEmpty(stockRecordId)){
            throw new WebErrorFactory("扣库存批次不能为空");
        }
        StockRecordEntity stockRecordEntity = stockRecordService.getById(stockRecordId);
        stockRecordEntity.setStock(deductStockResultDto.getStock());
        stockRecordEntity.setVersion(deductStockResultDto.getVersion());
        stockRecordEntity.setStatus(0);
        stockRecordService.updateById(stockRecordEntity);
    }

    /**
     * 记录扣库存流水
     * @param orderCode
     * @param productCode
     * @param num
     * @return
     */
    private Long saveStockRecord(String batchNo,String orderCode, String productCode, Integer num) {
        StockRecordEntity stockRecordEntity = StockRecordEntity.builder()
                .batchNo(batchNo)
                .num(1)
                .orderCode(orderCode)
                .productCode(productCode)
                .status(1)
                .stock(-1)
                .version(0)
                .build();
        stockRecordService.insert(stockRecordEntity);
        return stockRecordEntity.getId();
    }
}
