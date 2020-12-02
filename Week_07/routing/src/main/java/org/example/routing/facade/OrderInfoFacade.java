package org.example.routing.facade;

import org.example.routing.dto.param.OrderInfoParam;
import org.example.routing.entity.OrderInfo;

/**
 * @author Duansg
 */
public interface OrderInfoFacade {
    /**
     *
     * @param orderCode
     * @return
     */
    OrderInfo selectOrderInfoByCode(String orderCode);

    /**
     *
     * @param param
     * @return
     */
    Boolean saveOrder(OrderInfoParam.CreateParam param);

    /**
     *
     * @param param
     * @return
     */
    Boolean checkOrderAndSave(OrderInfoParam.CreateParam param);
}
