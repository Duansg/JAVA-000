package org.product.domain;

import lombok.Data;

/**
 * CheckStockParam
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午3:19
 */
@Data
public class CheckStockParam {


    private String productCode;

    private String orderCode;

}
