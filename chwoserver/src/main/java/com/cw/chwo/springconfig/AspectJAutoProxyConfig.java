package com.cw.chwo.springconfig;

import com.cw.chwo.common.annotationmerge.WiselyConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by handl on 2017/8/17.
 *
 *
 * 艾特EnableAspectJAutoProxy：启动AOP自动代理
 *
 */
@WiselyConfiguration
@EnableAspectJAutoProxy
public class AspectJAutoProxyConfig {
}
