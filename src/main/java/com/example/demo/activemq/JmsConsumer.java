package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.io.IOException;

/**
 * 消费者演示
 */
public class JmsConsumer {

//    public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String ACTIVE_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        // 消费者事务，当开启true ，也需要使用session.commit
        // 第二个参数是签收类型，现在是自动签收。如果是手动签收，需要在消费者
        // 获取到消息后，使用消息的acknowledged方法
        /// 如果消费者开启事务，有没有重复消费要以事务为准。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);
        System.out.println("我是1号消费者");
/*     方式一：通过监听的方式
        while(true) {

            TextMessage receive = (TextMessage)consumer.receive();
            String text = receive.getText();
            if (text != null) {
                System.out.println("消费者消费消息：" + text);
            }else {
                break;
            }

        }*/

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

        //session.commit();
        consumer.close();
        session.close();
        connection.close();
    }

}
