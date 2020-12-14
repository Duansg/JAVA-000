package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.OrderInfo;

/**
 * OrderInfoMapper
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 下午10:18
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {


}
