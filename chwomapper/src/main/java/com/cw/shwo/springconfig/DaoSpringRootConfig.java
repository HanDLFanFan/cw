package com.cw.shwo.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by handl on 2017/6/3.
 */
@Configuration
@Import(DaoSpringdbConfig.class)
@ComponentScan(basePackages = "com.cw.chwo")
public class DaoSpringRootConfig {
}
