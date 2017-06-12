package com.cw.chwo.springconfig;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by handl on 2017/6/12.
 */
@Configuration
public class ServerSpringMqConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(environment.getProperty("mq.url"));
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
        activeMQQueue.setPhysicalName("chwo.queue");
        return activeMQQueue;
    }

    @Bean
    public ActiveMQTopic activeMQTopic(){
        ActiveMQTopic activeMQTopic = new ActiveMQTopic();
        activeMQTopic.setPhysicalName("chwo.topic");
        return activeMQTopic;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory,ActiveMQQueue activeMQQueue){
        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(activeMQQueue);
        return jmsTemplate;
    }
}
