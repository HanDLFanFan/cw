package com.cw.shwo.server.impl;

import com.cw.chwo.server.ChwoService;

/**
 * Created by handl on 2017/5/20.
 */
@Component
public class ChwoServiceImpl implements ChwoService{
    @Override
    public void say() {
        System.out.println("hello chwo!");
    }
}
