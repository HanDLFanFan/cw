package com.cw.chwo.springconfig;

import com.cw.chwo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by handl on 2017/8/16.
 */

public class ServerSpringContextConfigTest extends BaseTest {

    @Autowired
    private ServerSpringContextConfig serverSpringContextConfig;

    //测试spring el表达式注入
    @Test
    public void testAutowired(){
        serverSpringContextConfig.testAutoired();
    }

}
