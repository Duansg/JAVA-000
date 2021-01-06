package org.example.support;

import com.alibaba.fastjson.JSON;
import org.example.constant.ChannelConstant;
import org.example.dto.OrderSendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RedisPubSubSupport
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午11:21
 */
@Component
public class RedisPubSupport extends ChannelConstant {

    @Autowired
    private RedisTemplate redisTemplate;

    public void send(String channel, OrderSendDto orderSendDto) {
        redisTemplate.convertAndSend(channel, orderSendDto);
    }
}
