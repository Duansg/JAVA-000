package org.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.common.base.BaseEntity;

/**
 * ProductInfoEntity
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午3:21
 */
@Data
@Builder
@TableName("product_info")
@EqualsAndHashCode(callSuper = true)
public class ProductInfoEntity extends BaseEntity<ProductInfoEntity> {


    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 产品编码
     */
    private String productCode;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品状态(0:启用，1：禁用)
     */
    private Integer productStatus;
    /**
     * 库存
     */
    private Integer stock;

}
