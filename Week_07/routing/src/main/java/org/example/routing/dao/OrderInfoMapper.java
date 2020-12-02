package org.example.routing.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.routing.entity.OrderInfo;

/**
 * 订单信息表
 * @author Duansg
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

}
