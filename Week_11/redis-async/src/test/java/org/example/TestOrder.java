package org.example;

import org.example.facade.OrderFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestCount
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServer.class)
public class TestOrder {

    @Autowired
    private OrderFacade orderFacade;
    @Test
    public void test(){
        String result = orderFacade.saveOrder("Duansg");
        System.out.println(result);
    }

}
