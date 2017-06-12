package com.cw.chwo.service;

import com.cw.chwo.module.User;

/**
 * Created by handl on 2017/6/12.
 */
public interface MqUserService {
    //发送消息到队列
    void sendMqToCreateUser(User user);
    //消费(接收)消息
    void receive();
}
