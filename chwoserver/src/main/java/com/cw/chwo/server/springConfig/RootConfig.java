package com.cw.chwo.server.springConfig;

import com.cw.chwo.server.MarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by handl on 2017/5/20.
 */
@Import(SpringConfig.class)
@ComponentScan(basePackageClasses = MarkerInterface.class)
@PropertySource("classpath:/system.properties")
@EnableAspectJAutoProxy
public class RootConfig {
}
