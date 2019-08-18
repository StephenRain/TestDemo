package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * 消费者演示
 *  基于 Topic---持久化的
 *  即发布订阅模式：
 *      一对多，所有消费者只能在订阅后收到消息，无法收到订阅前的消息。
 *
 *  注意：这里演示失败，订阅者无法获取消息。原因未知
 */
public class JmsConsumer_Topic_Persistent {

    public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String TOPIC_NAME = "topic_persistent";

    public static void main(String[] args) throws JMSException, IOException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();
        connection.setClientID("z3");
        System.out.println("我是张三" );

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "remark..");
        connection.start();

        Message message = durableSubscriber.receive();

        while ( null != message) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("****收到持久化Topic" + textMessage.getText());
            message = durableSubscriber.receive(5000L);
        }

        session.close();
        connection.close();
    }

}
