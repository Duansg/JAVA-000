package org.example.shardingsphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.shardingsphere.base.BaseCustomServiceInterfaceImpl;
import org.example.shardingsphere.dao.OrderInfoMapper;
import org.example.shardingsphere.entity.OrderInfo;
import org.example.shardingsphere.service.OrderInfoService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * OrderInfoServiceImpl
 * @author Duansg
 * @version 1.0
 */
@Service
public class OrderInfoServiceImpl extends BaseCustomServiceInterfaceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Override
    public OrderInfo selectById(Long id) {
        return super.selectById(id);
    }

    @Override
    public OrderInfo selectOne(Wrapper<OrderInfo> queryWrapper) {
        return super.selectOne(queryWrapper);
    }

    @Override
    public IPage<OrderInfo> selectPage(IPage<OrderInfo> page, Wrapper<OrderInfo> queryWrapper) {
        return super.selectPage(page, queryWrapper);
    }

    @Override
    public List<OrderInfo> selectList(Wrapper<OrderInfo> queryWrapper) {
        return super.selectList(queryWrapper);
    }

    @Override
    public boolean insert(OrderInfo orderInfo) {
        return super.insert(orderInfo);
    }

    @Override
    public OrderInfo updateByDataId(OrderInfo orderInfo) {
        return super.updateByDataId(orderInfo);
    }

    @Override
    public boolean deleteById(OrderInfo orderInfo) {
        return super.deleteById(orderInfo);
    }
}
