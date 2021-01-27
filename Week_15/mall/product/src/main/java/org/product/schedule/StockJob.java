package org.product.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.SneakyThrows;
import org.product.dto.DeductStockResultDto;
import org.product.entity.ProductInfoEntity;
import org.product.entity.StockRecordEntity;
import org.product.service.ProductInfoService;
import org.product.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * StockJob
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午8:43
 */
@Component
//@EnableScheduling
public class StockJob {

    @Autowired
    private StockRecordService stockRecordService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

//    @Scheduled(cron = "0/5 * * * * ?")
////    @Transactional(rollbackFor = Exception.class)
    @PostConstruct
    public void runfirst() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Object object = redisTemplate.opsForList().rightPop("STOCK:STOCK_RECORD");
                    if (!ObjectUtils.isEmpty(object)){
                        DeductStockResultDto deductStockResultDto = JSON.parseObject(((JSONObject) object).toJSONString(), DeductStockResultDto.class);
                        String batchno = deductStockResultDto.getBatchno().replace("\"", "");
                        StockRecordEntity stockRecordEntity = stockRecordService.getOne(new QueryWrapper<StockRecordEntity>().lambda()
                                .eq(StockRecordEntity::getBatchNo, batchno)
                        );
                        stockRecordEntity.setVersion(3);
                        stockRecordService.updateById(stockRecordEntity);
                        ProductInfoEntity productInfoEntity = productInfoService.getOne(new QueryWrapper<ProductInfoEntity>().lambda()
                                .eq(ProductInfoEntity::getProductCode, stockRecordEntity.getProductCode())
                        );
                        productInfoEntity.setStock(productInfoEntity.getStock() - stockRecordEntity.getNum());
                        productInfoService.updateByDataId(productInfoEntity);
                        continue;
                    }
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        });
        thread.start();
    }


}
