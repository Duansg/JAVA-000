package org.example.shardingsphere.controller;

import org.example.shardingsphere.entity.OrderInfo;
import org.example.shardingsphere.facade.OrderInfoFacade;
import org.example.shardingsphere.param.OrderInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 * @author Duansg
 * @version 1.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderInfoFacade orderInfoFacade;

    @GetMapping(value = "/getOrderInfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OrderInfo getOrderInfo(String orderCode){
        return orderInfoFacade.selectOrderInfoByCode(orderCode);
    }

    @PostMapping(value = "/saveOrder", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Boolean saveOrder(OrderInfoParam.CreateParam param){
        return orderInfoFacade.saveOrder(param);
    }

}
