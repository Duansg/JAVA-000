package org.example.routing.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 * @author Duansg
 * @version 1.0
 */
@Data
public abstract class BaseEntity<T> implements Serializable {

    public static final String PROP_DELETED = "deleted";
    public static final String PROP_CREATE_BY = "createBy";
    public static final String PROP_CREATE_TIME = "createTime";
    public static final String PROP_MODIFY_BY = "updateBy";
    public static final String PROP_MODIFY_TIME = "updateTime";

    @TableId(
            type = IdType.ASSIGN_ID
    )
    protected Long id;
    @TableField(
            fill = FieldFill.INSERT
    )
    protected String createBy;
    @TableField(
            fill = FieldFill.INSERT
    )
    protected LocalDateTime createTime;
    @TableField(
            fill = FieldFill.UPDATE
    )
    protected String updateBy;
    @TableField(
            fill = FieldFill.UPDATE
    )
    protected LocalDateTime updateTime;
    @TableField(
            fill = FieldFill.INSERT
    )
    @TableLogic
    protected String deleted;
}
