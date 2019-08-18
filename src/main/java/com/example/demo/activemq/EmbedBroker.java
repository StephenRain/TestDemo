package com.example.demo.activemq;

import org.apache.activemq.broker.BrokerService;

/**
 *  用Active Broker作为独立的消息服务器来构建JAVA应用。
 *  即这个就是ActiveMQ
 *
 */
public class EmbedBroker {


    public static void main(String[] args) throws Exception {

        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();


    }


}
