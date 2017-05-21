package com.cw.chwo.server.service.impl;

import com.cw.chwo.server.pojo.User;
import com.cw.chwo.server.service.ChwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/5/20.
 */
@Component
public class ChwoServiceImpl implements ChwoService {

    @Autowired
    private User user;

    @Override
    public String say(String name) {
        System.out.println("I'm is "+user.getName()+" And my age is "+user.getAge() + ",hello "+name);
        return "yes,is "+name;
    }
}
