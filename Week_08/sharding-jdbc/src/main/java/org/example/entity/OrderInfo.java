package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OrderInfo
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 下午10:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = DBFields.ID,type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(DBFields.ORDER_CODE)
    private String orderCode;

    @TableField(value = DBFields.STATUS)
    private Integer status;

    public static class DBFields{

        public final static String ID = "id";

        public final static String ORDER_CODE = "order_code";

        public final static String STATUS = "status";

    }

}
