package org.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.common.base.BaseCustomServiceInterfaceImpl;
import org.order.dao.OrderInfoMapper;
import org.order.entity.OrderInfoEntity;
import org.order.service.OrderInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderInfoServiceImpl
 * @author Duansg
 * @version 1.0
 */
@Service
public class OrderInfoServiceImpl extends BaseCustomServiceInterfaceImpl<OrderInfoMapper, OrderInfoEntity> implements OrderInfoService {

    @Override
    public OrderInfoEntity selectById(Long id) {
        return super.selectById(id);
    }

    @Override
    public OrderInfoEntity selectOne(Wrapper<OrderInfoEntity> queryWrapper) {
        return super.selectOne(queryWrapper);
    }

    @Override
    public IPage<OrderInfoEntity> selectPage(IPage<OrderInfoEntity> page, Wrapper<OrderInfoEntity> queryWrapper) {
        return super.selectPage(page, queryWrapper);
    }

    @Override
    public List<OrderInfoEntity> selectList(Wrapper<OrderInfoEntity> queryWrapper) {
        return super.selectList(queryWrapper);
    }

    @Override
    public boolean insert(OrderInfoEntity orderInfoEntity) {
        return super.insert(orderInfoEntity);
    }

    @Override
    public OrderInfoEntity updateByDataId(OrderInfoEntity orderInfoEntity) {
        return super.updateByDataId(orderInfoEntity);
    }

    @Override
    public boolean deleteById(OrderInfoEntity orderInfoEntity) {
        return super.deleteById(orderInfoEntity);
    }
}
