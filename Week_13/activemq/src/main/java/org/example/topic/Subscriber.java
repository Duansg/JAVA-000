package org.example.topic;

import org.apache.activemq.ActiveMQConnection;
import org.example.common.Config;

import javax.jms.*;
import java.util.UUID;

/**
 * Subscriber
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午9:12
 */
public class Subscriber {
    public static void main(String[] args) throws JMSException {
        Subscriber.start();
    }

    private static void start() throws JMSException {
        String consumerId = "consumer-" + UUID.randomUUID();
        Connection connection = ActiveMQConnection.makeConnection();
        connection.setClientID(consumerId);
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(Config.TOPIC);
        MessageConsumer consumer = session.createDurableSubscriber(topic, consumerId);
        consumer.setMessageListener(System.out::println);
    }




}
