package org.example.support;

import org.example.base.CustomMq;
import org.example.base.CustomMqBroker;
import org.example.base.CustomMqMessage;

/**
 * CustomMqConsumer
 * @author duansg
 * @version 1.0
 * @date 2021/1/20 下午10:44
 */
public class CustomMqConsumer<T> {

    private final CustomMqBroker broker;

    private CustomMq mq;

    public CustomMqConsumer(CustomMqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.mq = this.broker.findTopic(topic);
        if (null == mq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public CustomMqMessage<T> poll(long timeout) {
        return mq.poll(timeout);
    }

}
