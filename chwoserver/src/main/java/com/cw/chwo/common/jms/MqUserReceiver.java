package com.cw.chwo.common.jms;

import com.cw.chwo.module.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/6/16.
 */
@Component
public class MqUserReceiver {

    @JmsListener(destination = "chwo.queue")
    public void receiverMqToCreateUser(final Message<User> message) {
        System.out.println("消息接收-----------开始");
        MessageHeaders headers =  message.getHeaders();
        System.out.println("headers===="+headers);

        User user = message.getPayload();
        System.out.println("user===="+user);
        System.out.println("消息接收-----------结束");
    }
}
