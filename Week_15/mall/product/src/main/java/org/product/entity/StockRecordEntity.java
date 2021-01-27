package org.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.tools.internal.ws.processor.model.java.JavaType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import org.common.base.BaseEntity;

/**
 * StockRecordEntity
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午4:34
 */
@Data
@Builder
@TableName("stock_record")
@EqualsAndHashCode(callSuper = true)
public class StockRecordEntity extends BaseEntity<StockRecordEntity> {

    private static final long serialVersionUID = 1L;

    private  Long id;
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 扣减值
     */
    private Integer num;

    /**
     * 当前库存数量
     */
    private Integer stock;

    /**
     * 订单状态( 0:成功,1:待扣)
     */
    private Integer status;

    /**
     * 版本号
     */
    private Integer version;


}
