package org.example.queue;

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
        Connection connection = null;
        Session session = null;
        try {
            // 创建链接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, Config.BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            Destination destination = session.createQueue(Config.QUEUE);
            // 创建消息制作者
            MessageProducer producer = session.createProducer(destination);
            // 设置持久化模式
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 发送消息
            sendMessage(session, producer);
            // 提交会话
            session.commit();
        } finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }




    private static void sendMessage(final Session session, final MessageProducer producer) throws Exception {
        String message = "发送消息";
        TextMessage text = session.createTextMessage(message);
        System.out.println(message);
        producer.send(text);
    }


}
