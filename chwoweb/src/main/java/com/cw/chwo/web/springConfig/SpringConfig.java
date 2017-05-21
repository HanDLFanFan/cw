package com.cw.chwo.web.springConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by handl on 2017/5/20.
 */
@Configuration
public class SpringConfig {
    @Autowired
    private Environment environment;

}
