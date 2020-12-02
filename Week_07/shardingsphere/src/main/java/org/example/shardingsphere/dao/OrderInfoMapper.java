package org.example.shardingsphere.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.shardingsphere.entity.OrderInfo;

/**
 * 订单信息表
 * @author Duansg
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

}
