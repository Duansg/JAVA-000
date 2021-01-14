package org.example;

import org.example.service.Consumer;
import org.example.service.Provider;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午11:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServer.class)
public class Test {

    @Autowired
    private Provider provider;
    @Autowired
    private Consumer consumer;
    @org.junit.Test
    public void test() throws InterruptedException {
        provider.produce();
        System.out.println("PROVIDER SUCCESS");
        TimeUnit.MINUTES.sleep(1);
    }
}
