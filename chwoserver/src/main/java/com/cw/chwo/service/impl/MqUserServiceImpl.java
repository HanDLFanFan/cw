package com.cw.chwo.service.impl;

import com.cw.chwo.module.User;
import com.cw.chwo.service.MqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by handl on 2017/6/12.
 */
@Service
public class MqUserServiceImpl implements MqUserService {

   @Autowired
    private JmsOperations jmsOperations;

    @Override
    public void sendMqToCreateUser(User user) {
        System.out.println("消息开始发送");
        //send用法
        jmsOperations.send("chwo.queue",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(user);
                    }
                });

        //消息转换器的用法,因为jmsTemplate有默认的目的地，所以不需配置
//        jmsOperations.convertAndSend(user);
        System.out.println("消息开始完毕");
    }

    @Override
    public void receive() {
        System.out.println("开始接收消息");
        try {
            ObjectMessage receiveMessage = (ObjectMessage)jmsOperations.receive();
            User user = (User) receiveMessage.getObject();
            System.out.println("reveice:name="+user.getName());
            System.out.println("reveice:age="+user.getAge());
            System.out.println("reveice:mobile="+user.getMobile());
            System.out.println("reveice:email="+user.getEmail());
        } catch (JMSException e) {
            e.printStackTrace();
        }

        //消息转换器的用法
//        User user2 = (User)jmsOperations.receiveAndConvert();
    }
}
