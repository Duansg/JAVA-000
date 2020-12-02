package org.example.routing.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.routing.base.annotation.RouteDataSourceMerge;
import org.example.routing.dto.param.OrderInfoParam;
import org.example.routing.entity.OrderInfo;
import org.example.routing.facade.OrderInfoFacade;
import org.example.routing.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
                .orderCode(UUID.randomUUID().toString().replace("-",""))
                .quantity(param.getQuantity())
                .userId(param.getUserId())
                .build());
    }

    @Override
    @RouteDataSourceMerge
    public Boolean checkOrderAndSave(OrderInfoParam.CreateParam param) {
        String orderCode = UUID.randomUUID().toString().replace("-", "");
        orderInfoService.insert(OrderInfo.builder()
                .orderCode(orderCode)
                .quantity(param.getQuantity())
                .userId(param.getUserId())
                .build());
        orderInfoService.selectOne(new QueryWrapper<OrderInfo>().lambda()
                .eq(OrderInfo::getOrderCode, orderCode)
        );
        return true;
    }
}
