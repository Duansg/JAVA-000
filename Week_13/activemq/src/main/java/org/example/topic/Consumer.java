package org.example.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.common.Config;

import javax.jms.*;

/**
 * Consumer
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午9:01
 */
public class Consumer {


    public static void main(String[] args) throws Exception {
        Consumer.start();
    }

    private static void start() throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(Config.BROKER_URL);
        Connection connection = factory.createConnection(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD);
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(Config.TOPIC);
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            Message msg = consumer.receive();
            if (msg instanceof TextMessage) {
                String body = ((TextMessage) msg).getText();
                if ("SHUTDOWN".equals(body)) {
                    connection.close();
                    System.exit(0);
                } else {
                    System.out.println(((TextMessage) msg).getText());
                }
            }
        }
    }


}
