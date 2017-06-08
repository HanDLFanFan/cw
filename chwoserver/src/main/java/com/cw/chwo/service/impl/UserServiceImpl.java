package com.cw.chwo.service.impl;

import com.cw.chwo.module.User;
import com.cw.chwo.service.UserService;
import com.cw.chwo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * Created by handl on 2017/5/22.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

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

        if (redisTemplate.hasKey("123")){
            System.out.println("redis have data");
            BoundValueOperations<String,String> data = redisTemplate.boundValueOps("123");
            String[] userInfo = data.get().split(",");
            User user = new User();
            user.setName(userInfo[0]);
            user.setMobile(userInfo[1]);
            user.setAge(Integer.valueOf(userInfo[2]));
            return user;
        }

        System.out.println("redis not have data");
        User user = userDao.findUserById("123");
        String userdata = user.getName()+","+user.getMobile()+","+user.getAge();
        BoundValueOperations<String,String> data = redisTemplate.boundValueOps("123");
        data.set(userdata);
        return user;
    }
}
