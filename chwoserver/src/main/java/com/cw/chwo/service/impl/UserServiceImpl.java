package com.cw.chwo.service.impl;

import com.cw.chwo.mapper.UserDao;
import com.cw.chwo.module.User;
import com.cw.chwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by handl on 2017/5/22.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public String reg(User user) {

        if(user != null){
            System.out.println();
            System.out.println();
            System.out.println();
            return "注册成功,欢迎"+user.getName();
        }
        return "注册失败";
    }

    @Override
    public User findUser() {
        return userDao.findUserById("123");
    }
}
