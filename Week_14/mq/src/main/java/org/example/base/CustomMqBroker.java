package org.example.base;

import org.example.support.CustomMqConsumer;
import org.example.support.CustomMqProducter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * CustomMqBroker
 * @author duansg
 * @version 1.0
 * @date 2021/1/20 下午10:44
 */

public class CustomMqBroker {

    public static final int CAPACITY = 10000;

    private final Map<String, CustomMq> context = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        context.putIfAbsent(name, new CustomMq(name,CAPACITY));
    }

    public CustomMq findTopic(String topic) {
        return this.context.get(topic);
    }

    public CustomMqProducter createProducer() {
        return new CustomMqProducter(this);
    }

    public CustomMqConsumer createConsumer() {
        return new CustomMqConsumer(this);
    }

}