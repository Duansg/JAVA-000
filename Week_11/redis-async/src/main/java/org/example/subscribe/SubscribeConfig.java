package org.example.subscribe;

import org.example.support.RedisPubSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * SubscribeConfig
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午11:51
 */
@Configuration
public class SubscribeConfig {

    @Autowired
    private RedisTemplate redisTemplate;
    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new OrderSubscribe(redisTemplate));
    }

    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory factory) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(Object.class);
        container.setTopicSerializer(genericToStringSerializer);
        container.setConnectionFactory(factory);
        container.addMessageListener(messageListener(), new ChannelTopic(RedisPubSupport.SAVE_ORDER));
        return container;
    }
}
