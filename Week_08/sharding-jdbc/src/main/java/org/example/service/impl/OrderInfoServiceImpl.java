package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.OrderInfoMapper;
import org.example.entity.OrderInfo;
import org.example.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
 * OrderInfoServiceImpl
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 下午10:20
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {


}
