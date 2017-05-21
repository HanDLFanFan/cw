package com.cw.chwo.server;

import com.cw.chwo.server.service.ChwoService;
import com.cw.chwo.server.springConfig.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by handl on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ChwoServerTest {

    @Autowired
    private ChwoService chwoService;

    @Test
    public void sayTest(){
        chwoService.say("Word");
    }
}
