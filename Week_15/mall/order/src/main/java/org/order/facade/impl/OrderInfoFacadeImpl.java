package org.order.facade.impl;

import com.alibaba.fastjson.JSON;
import org.common.base.WebErrorFactory;
import org.order.domain.CreateOrderParam;
import org.order.dto.CheckStockDto;
import org.order.entity.OrderInfoEntity;
import org.order.facade.OrderInfoFacade;
import org.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * OrderFacadeImpl
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午12:43
 */
@Service
public class OrderInfoFacadeImpl implements OrderInfoFacade {

    @Autowired
    private OrderInfoService orderInfoService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveOrder(CreateOrderParam param) {
        String orderCode = UUID.randomUUID().toString().replace("-", "");
        checkStock(orderCode,param.getProductCode());
        orderInfoService.insert(OrderInfoEntity.builder()
                .linkMobile(param.getLinkMobile())
                .orderCode(orderCode)
                .linkName(param.getLinkName())
                .orderStatus(0)
                .build());
        return String.format("下单成功,订单号为:%s",orderCode) ;
    }

    private void checkStock(String orderCode,String productCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8082/checkStock";
        try{
            //默认下单只能下1个数量。
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(
                    CheckStockDto.builder()
                            .orderCode(orderCode)
                            .productCode(productCode)
                            .build()
            ), headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);
            System.out.println(response.getBody());
        }catch (Exception e){
            throw new WebErrorFactory("扣库存失败");
        }
    }
}
