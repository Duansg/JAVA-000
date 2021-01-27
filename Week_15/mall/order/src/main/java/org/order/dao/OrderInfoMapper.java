package org.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.order.entity.OrderInfoEntity;

/**
 * OrderInfoMapper
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午2:16
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfoEntity> {

}
