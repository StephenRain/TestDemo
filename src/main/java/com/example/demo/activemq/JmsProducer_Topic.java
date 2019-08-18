package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 演示消息的生产者
 *  基于Topic
 */
public class JmsProducer_Topic {

    public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String TOPIC_NAME = "queue01";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageProducer producer = session.createProducer(topic);

        for (int i = 0; i < 4; i++) {
            TextMessage textMessage = session.createTextMessage("msg----" + i);
            producer.send(textMessage);
        }

        System.out.println("生产完毕");
        producer.close();
        session.close();
        connection.close();
    }
}
