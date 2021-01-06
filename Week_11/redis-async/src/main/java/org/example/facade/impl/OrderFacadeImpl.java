package org.example.facade.impl;

import org.example.dto.OrderSendDto;
import org.example.facade.OrderFacade;
import org.example.support.RedisPubSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * OrderFacadeImpl
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午11:19
 */
@Service
public class OrderFacadeImpl implements OrderFacade {


    @Autowired
    private RedisPubSupport redisPubSupport;

    @Override
    public String saveOrder(String userName) {
        System.out.println("【下单】下单人名称：".concat(userName));
        String orderCode = UUID.randomUUID().toString().replace("-", "");
        System.out.println("【下单】生成订单号：".concat(orderCode));
        redisPubSupport.send(RedisPubSupport.SAVE_ORDER,OrderSendDto.builder()
                .orderCode(orderCode)
                .build());
        return "【下单】SUUCESS";
    }
}
