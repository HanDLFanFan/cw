package com.cw.chwo.springconfig;

import com.cw.chwo.common.annotationmerge.WiselyConfiguration;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

/**
 *      艾特EnableJms：启动注解jms监听器
 *
 * Created by handl on 2017/6/12.
 */
@WiselyConfiguration
@EnableJms
public class ServerSpringMqConfig {

    @Autowired
    private Environment environment;


    /**
     * activeMq连接工厂
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(environment.getProperty("mq.url"));
        connectionFactory.setTrustedPackages(Arrays.asList("com.cw.chwo","java.util","java.lang"));
        return connectionFactory;
    }

    /**
     * 消息模板(类似于redis模板和jdbc模板)
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName("chwo.queue");
        return template;
    }

    /**
     * jms消息监听工厂(异步方式)
     * @return
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1");
        return factory;
    }
}
