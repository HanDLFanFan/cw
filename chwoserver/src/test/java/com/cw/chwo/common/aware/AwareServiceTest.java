package com.cw.chwo.common.aware;

import com.cw.chwo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by handl on 2017/8/17.
 */
public class AwareServiceTest extends BaseTest{

    @Autowired
    private AwareService awareService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void awareTest(){
        awareService.setApplicationContext(applicationContext);
    }
}
