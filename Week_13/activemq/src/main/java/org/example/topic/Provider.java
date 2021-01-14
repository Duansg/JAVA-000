package org.example.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.common.Config;

import javax.jms.*;

/**
 * Provider
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午9:01
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        Provider.start();
    }

    private static void start() throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(Config.BROKER_URL);
        Connection connection = factory.createConnection(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD);
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(Config.TOPIC);
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        sendMessage(session, producer);
        //发送关闭消息
        producer.send(session.createTextMessage("SHUTDOWN"));
        Thread.sleep(1000 * 3);
        connection.close();
        System.exit(0);
    }




    private static void sendMessage(final Session session, final MessageProducer producer) throws Exception {
        String message = "发送消息";
        TextMessage text = session.createTextMessage(message);
        System.out.println(message);
        producer.send(text);
    }


}
