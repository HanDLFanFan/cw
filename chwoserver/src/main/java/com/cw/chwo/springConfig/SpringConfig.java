package com.cw.chwo.springConfig;

import com.cw.chwo.server.MarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handl on 2017/5/20.
 */
@Configuration
@ComponentScan(basePackageClasses = MarkerInterface.class)
public class SpringConfig {
}
