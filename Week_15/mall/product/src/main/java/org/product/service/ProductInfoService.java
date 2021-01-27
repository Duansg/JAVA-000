package org.product.service;

import org.common.base.BaseCustomServiceInterface;
import org.product.entity.ProductInfoEntity;

/**
 * @author Duansg
 */
public interface ProductInfoService extends BaseCustomServiceInterface<ProductInfoEntity,Long> {

    ProductInfoEntity getForUpdate(Long id);
}
