package org.example.routing.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.routing.base.BaseEntity;
import java.math.BigDecimal;

/**
 * 订单信息表
 *
 * @author Duansg
 * @date 2020-07-27 15:32:13
 */
@Data
@Builder
@TableName("order_info")
@EqualsAndHashCode(callSuper = true)
public class OrderInfo extends BaseEntity<OrderInfo> {

    private static final long serialVersionUID = 1L;
                
    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 用户ID
     */
    private Long userId;
            
    /**
     * 订单类型(0:套票,1:电子卡卷,2:实物商品)
     */
    private Integer orderType;
            
    /**
     * 订单来源(0:小程序)
     */
    private Integer wayType;
            
    /**
     * 支付状态(0:未支付,1:支付失败,2:支付过期,3:已支付)
     */
    private Integer payStatus;
            
    /**
     * 支付类型(0:支付宝,1:微信,2:其他//TODO)
     */
    private Integer payType;
            
    /**
     * 支付金额
     */
    private BigDecimal paySum;
            
    /**
     * 订单最终金额
     */
    private BigDecimal orderSum;
            
    /**
     * 订单结算金额
     */
    private BigDecimal settleSum;

    /**
     * 数量
     */
    private Integer quantity;
            
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

    private String thirdPayNo;

    private String distributorCode;

    private String tenantId;
}
