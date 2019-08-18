package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * 消费者演示
 *  基于 Topic
 *  即发布订阅模式：
 *      一对多，所有消费者只能在订阅后收到消息，无法收到订阅前的消息。
 *  先启动消费者
 */
public class JmsConsumer_Topic {

    public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String TOPIC_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageConsumer consumer = session.createConsumer(topic);
        System.out.println("我是2号消费者");

        // 方式二：设置监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

                if (message instanceof TextMessage) {

                    TextMessage textMessage = (TextMessage) message;

                    try {
                        System.out.println("消费者通过设置监听器收到消息： " + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }


                }
            }
        });

        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }

}
