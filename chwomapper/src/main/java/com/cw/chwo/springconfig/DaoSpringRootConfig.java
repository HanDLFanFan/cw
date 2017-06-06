package com.cw.chwo.springconfig;

import com.cw.chwo.MarkerInterface2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by handl on 2017/6/3.
 */
@Configuration
@Import({DaoSpringdbConfig.class})
@ComponentScan(basePackageClasses = MarkerInterface2.class)
@PropertySource("classpath:/database.properties")
public class DaoSpringRootConfig {
}
