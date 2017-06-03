package com.cw.chwo.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by handl on 2017/6/3.
 */
public interface UserDao {

    @Select("select * from user where id=#{id}")
    void findUserById(String id);
}
