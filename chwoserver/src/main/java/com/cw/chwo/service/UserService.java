package com.cw.chwo.service;

import com.cw.chwo.module.User;

/**
 * Created by handl on 2017/5/22.
 */
public interface UserService {
    String reg(User user);

    User findUser(String id);
}
