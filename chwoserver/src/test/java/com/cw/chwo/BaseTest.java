package com.cw.chwo;

import com.cw.chwo.springconfig.ServerSpringRootConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by handl on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServerSpringRootConfig.class)
public class BaseTest {
}
