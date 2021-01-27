package org.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.common.base.BaseEntity;

/**
 * OrderInfoEntity
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午2:16
 */
@Data
@Builder
@TableName("order_info")
@EqualsAndHashCode(callSuper = true)
public class OrderInfoEntity extends BaseEntity<OrderInfoEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单状态( 0-待付款; 1-待发货; 2-已发货; 5-订单成功; 6-退款中; 7-退款完成; 8-订单关闭;)
     */
    private Integer orderStatus;

    /**
     * 联系人姓名
     */
    private String linkName;

    /**
     * 联系方式
     */
    private String linkMobile;

}