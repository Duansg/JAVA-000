package org.example.support;

import org.example.base.CustomMq;
import org.example.base.CustomMqBroker;
import org.example.base.CustomMqMessage;

/**
 * CustomMqProducter
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/20 下午10:45
 */
public class CustomMqProducter {

    private CustomMqBroker broker;

    public CustomMqProducter(CustomMqBroker broker){
        this.broker = broker;
    }

    public boolean send(String topic, CustomMqMessage message){
        CustomMq mq = this.broker.findTopic(topic);
        if(null == mq){
            throw new RuntimeException("Topic [ " + topic +"] doesn't exist ");
        }
        return mq.send(message);
    }

}