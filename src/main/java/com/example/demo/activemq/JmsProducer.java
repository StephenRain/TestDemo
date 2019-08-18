package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 演示消息的生产者
 */
public class JmsProducer {

    //public static final String ACTIVE_URL = "tcp://192.168.1.109:61616";
    public static final String ACTIVE_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        // 第一个参数是事务，如果是true，表示开启事务
        // 那么需要使用 session.commit提交后才会将消息提交到队列中
        // 当出现异常，可以使用session.rollback 回滚。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);
        // 消息的持久化，中间件即使down这条消息也能使用。
        // 队列默认就是持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for (int i = 0; i < 16; i++) {
            TextMessage textMessage = session.createTextMessage("msg----" + i);
            // 这里可以设置该消息属性
            textMessage.setStringProperty("co1","vip");
            /*  设置 mapMessage
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("k1","v1");*/
            producer.send(textMessage);
        }

        System.out.println("生产完毕");
        producer.close();
        session.close();
        connection.close();
    }
}
