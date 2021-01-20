package org.example;

import org.example.base.CustomMqBroker;
import org.example.base.CustomMqMessage;
import org.example.support.CustomMqConsumer;
import org.example.support.CustomMqProducter;

public class ApplicationServer {

    public static void main(String[] args) throws Exception {
        String topic = "Duansg";
        CustomMqBroker broker = new CustomMqBroker();
        broker.createTopic(topic);
        CustomMqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);

        CustomMqProducter producer = broker.createProducer();
        producer.send(topic,new CustomMqMessage(null,"SUCCESS"));

        new Thread(() -> {
            CustomMqMessage<String> message = consumer.poll(100);
            if(null != message){
                System.err.println(String.format("消费成功,消息内容为:%s",message.getBody()));
            }
        }).start();

    }

}
