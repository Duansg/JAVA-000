package org.example.controller;

import org.example.facade.OrderFacade;
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
 * @date 2021/1/6 下午11:18
 */
@RestController
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    /**
     * @param userName
     * @return
     */
    @PostMapping(value = "/envelope", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String create(@RequestBody String userName) {
        return orderFacade.saveOrder(userName);
    }
}
