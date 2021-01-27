package org.product.domain;

import lombok.Data;

/**
 * CreateProductParam
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午3:18
 */
@Data
public class CreateProductParam {
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 库存
     */
    private Integer stock;
}
