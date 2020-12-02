package org.example.shardingsphere.facade;

import org.example.shardingsphere.entity.OrderInfo;
import org.example.shardingsphere.param.OrderInfoParam;

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
}
