package org.example;

import example.ApplicationServer;
import example.count.RedisCountSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * TestCount
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServer.class)
public class TestCount {

    @Test
    public void test(){
        String productCode = UUID.randomUUID().toString().replace("-", "");
        RedisCountSupport.setStock(productCode,3);
        for (int i = 0; i < 4; i++) {
            boolean b = RedisCountSupport.deductStock(productCode, 1);
            System.out.println(b);
        }
    }

}
