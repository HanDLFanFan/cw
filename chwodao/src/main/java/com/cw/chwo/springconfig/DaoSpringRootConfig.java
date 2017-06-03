package com.cw.chwo.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by handl on 2017/6/3.
 */
@Configuration
@Import(com.cw.chwo.springconfig.DaoSpringdbConfig.class)
@ComponentScan(basePackages = "com.cw.chwo.mapper")
@PropertySource("classpath:/database.properties")
public class DaoSpringRootConfig {
}
