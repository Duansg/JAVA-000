package org.example.subscribe;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dto.OrderSendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * OrderSubscribe
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午11:20
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderSubscribe implements MessageListener {

    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String channelName = (String) redisTemplate.getValueSerializer().deserialize(message.getChannel());
        System.out.println("【渠道】：".concat(channelName));
        String messageBody = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println("【接收到消息监听】：".concat(messageBody));
    }
}
