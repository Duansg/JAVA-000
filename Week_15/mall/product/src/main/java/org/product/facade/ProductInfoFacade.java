package org.product.facade;

import org.product.domain.CheckStockParam;
import org.product.domain.CreateProductParam;

public interface ProductInfoFacade {
    /**
     * 保存产品
     * @param param
     * @return
     */
    String saveProduct(CreateProductParam param);

    /**
     * 扣减库存
     * @param param
     * @return
     */
    String checkStock(CheckStockParam param);
}
