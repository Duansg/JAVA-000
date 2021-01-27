package org.order.controller;

import org.order.domain.CreateOrderParam;
import org.order.facade.OrderInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午12:42
 */
@RestController
public class OrderInfoController {

    @Autowired
    private OrderInfoFacade orderInfoFacade;

    @PostMapping(value = "/createOrder", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    private String create(@RequestBody CreateOrderParam param){
        return orderInfoFacade.saveOrder(param);
    }
}
