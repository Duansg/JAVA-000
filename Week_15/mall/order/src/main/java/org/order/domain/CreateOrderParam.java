package org.order.domain;

import lombok.Data;

/**
 * CreateOrderParam
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午2:39
 */
@Data
public class CreateOrderParam {

    /**
     * 联系人姓名
     */
    private String linkName;

    /**
     * 联系方式
     */
    private String linkMobile;

    /**
     * 产品编码
     */
    private String productCode;


}
