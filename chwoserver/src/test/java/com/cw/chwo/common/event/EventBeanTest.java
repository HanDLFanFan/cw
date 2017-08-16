package com.cw.chwo.common.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by handl on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.cw.chwo.springconfig.ServerSpringRootConfig.class)
public class EventBeanTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Test
    public void publishMsg(){
        eventPublisher.publish("你好！我是发送器，我正在发送消息，你收到了吗！！");
    }

}
