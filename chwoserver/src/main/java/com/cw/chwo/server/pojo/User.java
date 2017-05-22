package com.cw.chwo.server.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by handl on 2017/5/20.
 */
public class User {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
