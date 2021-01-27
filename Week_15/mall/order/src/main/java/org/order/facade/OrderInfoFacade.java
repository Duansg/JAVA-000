package org.order.facade;

import org.order.domain.CreateOrderParam;

public interface OrderInfoFacade {

    String saveOrder(CreateOrderParam param);
}
