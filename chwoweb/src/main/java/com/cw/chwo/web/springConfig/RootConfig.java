package com.cw.chwo.web.springConfig;

import com.cw.chwo.web.MarkerInterface;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by handl on 2017/5/20.
 */
@Import(SpringConfig.class)
@ComponentScan(basePackages = {"com.cw.chwo.web"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
@EnableAspectJAutoProxy
public class RootConfig {
}
