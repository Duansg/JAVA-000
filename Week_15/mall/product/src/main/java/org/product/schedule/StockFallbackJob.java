package org.product.schedule;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.SneakyThrows;
import org.product.entity.ProductInfoEntity;
import org.product.entity.StockRecordEntity;
import org.product.service.ProductInfoService;
import org.product.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * StockFallbackJob
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/28 上午12:20
 */
@Component
public class StockFallbackJob {
    @Autowired
    private StockRecordService stockRecordService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void runfirst() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Object object = redisTemplate.opsForList().rightPop("STOCK:STOCK_FALLBACK");
                    if (!ObjectUtils.isEmpty(object)){
                        StockRecordEntity stockRecordEntity = stockRecordService.getOne(new QueryWrapper<StockRecordEntity>().lambda()
                                .eq(StockRecordEntity::getBatchNo, String.valueOf(object))
                        );
                        //加回库存
                        redisTemplate.opsForValue().increment(String.format("STOCK:STOCKNUM_%s", stockRecordEntity.getProductCode()),stockRecordEntity.getNum());
                        stockRecordEntity.setVersion(-1);
                        stockRecordService.updateById(stockRecordEntity);
                        ProductInfoEntity productInfoEntity = productInfoService.getOne(new QueryWrapper<ProductInfoEntity>().lambda()
                                .eq(ProductInfoEntity::getProductCode, stockRecordEntity.getProductCode())
                        );
                        productInfoEntity.setStock(productInfoEntity.getStock() + stockRecordEntity.getNum());
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
