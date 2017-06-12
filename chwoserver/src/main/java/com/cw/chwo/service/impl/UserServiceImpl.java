package com.cw.chwo.service.impl;

import com.cw.chwo.module.User;
import com.cw.chwo.service.MqUserService;
import com.cw.chwo.service.UserService;
import com.cw.chwo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private MqUserService mqUserService;


    @Override
    public String reg(User user) {

        if(user != null){
            System.out.println();
            System.out.println();
            System.out.println();
            mqUserService.sendMqToCreateUser(user);
            return "注册成功,欢迎"+user.getName();
        }
        return "注册失败";
    }

    @Override
    @Cacheable("user2")
    public User findUser(String id) {
        /*if (redisTemplate.hasKey(id)){
            System.out.println("redis have data");
            BoundValueOperations<String,String> data = redisTemplate.boundValueOps(id);
            String[] userInfo = data.get().split(",");
            User user = new User();
            user.setName(userInfo[0]);
            user.setMobile(userInfo[1]);
            user.setAge(Integer.valueOf(userInfo[2]));
            return user;
        }*/

        System.out.println("redis not have data");
        User user = userDao.findUserById(id);
//        String userdata = user.getName()+","+user.getMobile()+","+user.getAge();
//        BoundValueOperations<String,String> data = redisTemplate.boundValueOps(id);
//        data.set(userdata);
        return user;
    }
}
