package com.cw.chwo.common.jms;

import com.cw.chwo.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by handl on 2017/6/12.
 */
@Component
public class MqUserSender{

   @Autowired
    private JmsOperations jmsOperations;

    public void sendMqToCreateUser(User user) {
        System.out.println("消息发送------开始");
        //send用法
        jmsOperations.send(
                new MessageCreator() {
                    @Override
                    public javax.jms.Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(user);
                    }
                });

        //消息转换器的用法,因为jmsTemplate有默认的目的地，所以不需配置
//        jmsOperations.convertAndSend(user);
        System.out.println("消息发送------结束");
    }
}
