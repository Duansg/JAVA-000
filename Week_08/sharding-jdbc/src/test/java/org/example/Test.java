package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.OrderInfo;
import org.example.service.OrderInfoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Random;

/**
 * Test
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 下午10:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class Test {

    @Autowired
    private OrderInfoService orderInfoService;

    @org.junit.Test
    public void insert(){
        OrderInfo entity = new OrderInfo();
        Random random = new Random();
        entity.setOrderCode(String.valueOf(random.nextInt(10000)));
//        entity.setOrderCode(String.valueOf(1));
        entity.setStatus(0);
        boolean save = orderInfoService.save(entity);
        System.out.println(save);
    }

    @org.junit.Test
    public void del(){
        //在不知道是哪个库的前提下，会删除两个库里面的数据
        boolean b = orderInfoService.removeById("1337348308472991745");
        System.out.println(b);
    }

    @org.junit.Test
    public void select(){
        OrderInfo one = orderInfoService.getOne(new QueryWrapper<OrderInfo>().lambda()
                .eq(OrderInfo::getId, "1337348308472991745")
                .eq(OrderInfo::getOrderCode, "4082")
        );
        System.out.println(one);

    }
    @org.junit.Test
    public void update(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setStatus(1);
        boolean update = orderInfoService.update(orderInfo, new QueryWrapper<OrderInfo>().lambda()
                .eq(OrderInfo::getId, "1337349695730647042")
                .eq(OrderInfo::getOrderCode, "3475")
        );
        System.out.println(update);
    }
}
