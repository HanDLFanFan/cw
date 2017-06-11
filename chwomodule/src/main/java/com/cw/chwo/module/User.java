package com.cw.chwo.module;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by handl on 2017/5/20.
 */
@XmlRootElement(name = "user")
public class User implements Serializable{

    private String id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private String mobile;

    public String getMobile() {
        return mobile;
    }
    @XmlElement
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }
    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    @XmlElement
    public void setAge(Integer age) {
        this.age = age;
    }
}
