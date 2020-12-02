package org.example.shardingsphere.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.shardingsphere.entity.OrderInfo;
import org.example.shardingsphere.facade.OrderInfoFacade;
import org.example.shardingsphere.param.OrderInfoParam;
import org.example.shardingsphere.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderInfoFacadeImpl
 * @author duansg
 * @version 1.0
 */
@Service
public class OrderInfoFacadeImpl implements OrderInfoFacade {

    @Autowired
    private OrderInfoService orderInfoService;


    @Override
    public OrderInfo selectOrderInfoByCode(String orderCode) {
        return orderInfoService.selectOne(new QueryWrapper<OrderInfo>().lambda()
                .eq(OrderInfo::getOrderCode, orderCode)
        );
    }

    @Override
    public Boolean saveOrder(OrderInfoParam.CreateParam param) {
        return orderInfoService.insert(OrderInfo.builder()
                .quantity(param.getQuantity())
                .userId(param.getUserId())
                .build());
    }
}
