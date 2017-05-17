package com.cw.chwo.server;

import com.cw.chwo.util.IPUtil;

/**
 * Created by handl on 2017/5/14.
 */
public class IPClass {

    public void say(){
        System.out.println(IPUtil.getIPAdress());
    }

    public static void main(String[] args) {
        new IPClass().say();
    }
}
