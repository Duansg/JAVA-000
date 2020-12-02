package org.example.routing.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.routing.base.BaseCustomServiceInterfaceImpl;
import org.example.routing.base.annotation.RouteDataSource;
import org.example.routing.dao.OrderInfoMapper;
import org.example.routing.entity.OrderInfo;
import org.example.routing.enums.RouteSourceEnum;
import org.example.routing.service.OrderInfoService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * OrderInfoServiceImpl
 * @author Duansg
 * @version 1.0
 * @see org.example.routing.facade
 */
@Service
public class OrderInfoServiceImpl extends BaseCustomServiceInterfaceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Override
    public OrderInfo selectById(Long id) {
        return super.selectById(id);
    }

    @Override
    @RouteDataSource(target = RouteSourceEnum.SLAVE)
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
    @RouteDataSource(target = RouteSourceEnum.MASTER)
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
