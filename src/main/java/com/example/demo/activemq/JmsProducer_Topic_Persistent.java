package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 演示消息的生产者
 *  基于Topic
 *  持久化
 */
public class JmsProducer_Topic_Persistent {

    public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String TOPIC_NAME = "topic_persistent";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();

        // 第一个参数事务，第二个是签收。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        connection.start();
        for (int i = 0; i < 4; i++) {
            TextMessage textMessage = session.createTextMessage("topic_mesg_persistent-" + i);
            producer.send(textMessage);
        }

        System.out.println("生产完毕");
        producer.close();
        session.close();
        connection.close();
    }
}
