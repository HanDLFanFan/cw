package com.cw.chwo.service.impl;

import com.cw.chwo.service.DemoTestService;
import org.springframework.stereotype.Service;

/**
 * Created by handl on 2017/8/19.
 *
 * 为了编写测试案例所需要的serviceImpl
 *
 */
@Service
public class DemoTestServiceImpl implements DemoTestService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
