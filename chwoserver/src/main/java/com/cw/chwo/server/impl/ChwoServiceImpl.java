package com.cw.chwo.server.impl;

import com.cw.chwo.server.ChwoService;
import org.springframework.stereotype.Component;

/**
 * Created by handl on 2017/5/20.
 */
@Component
public class ChwoServiceImpl implements ChwoService {
    @Override
    public void say() {
        System.out.println("hello chwo!");
    }
}
