package com.cw.chwo.springconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by handl on 2017/8/16.
 */

@Service
public class OutherClassPro {

    @Value("测试注入其他类属性") //此处为注入的字符串
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
