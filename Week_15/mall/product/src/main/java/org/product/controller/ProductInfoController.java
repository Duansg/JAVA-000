package org.product.controller;

import org.product.domain.CheckStockParam;
import org.product.domain.CreateProductParam;
import org.product.facade.ProductInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductInfoController
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午3:16
 */
@RestController
public class ProductInfoController {

    @Autowired
    private ProductInfoFacade productInfoFacade;

    @PostMapping(value = "/createProduct", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    private String create(@RequestBody CreateProductParam param){
        return productInfoFacade.saveProduct(param);
    }

    @PostMapping(value = "/checkStock", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    private String create(@RequestBody CheckStockParam param){
        return productInfoFacade.checkStock(param);
    }
}
