package com.cw.chwo.springconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by handl on 2017/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.cw.chwo.springconfig.ServerSpringRootConfig.class)
public class ServerSpringContextConfigTest {

    @Autowired
    private ServerSpringContextConfig serverSpringContextConfig;

    //测试spring el表达式注入
    @Test
    public void testAutowired(){
        serverSpringContextConfig.testAutoired();
    }

}
