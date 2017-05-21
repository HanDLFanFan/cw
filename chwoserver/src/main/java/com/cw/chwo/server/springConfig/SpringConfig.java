package com.cw.chwo.server.springConfig;

import com.cw.chwo.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

/**
 * Created by handl on 2017/5/20.
 */
@Configuration
public class SpringConfig {
    @Autowired
    private Environment environment;
    @Value("${name}")
    private String name;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public User user(){
        return new User(name,
                environment.getProperty("age",Integer.class));
    }

}
