package com.cw.chwo.server.service.impl;

import com.cw.chwo.server.pojo.User;
import com.cw.chwo.server.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by handl on 2017/5/22.
 */
@Service
public class UserServiceImpl implements UserService{

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
}
