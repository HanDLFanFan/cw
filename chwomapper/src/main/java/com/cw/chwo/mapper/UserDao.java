package com.cw.chwo.mapper;

import com.cw.chwo.module.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by handl on 2017/6/3.
 */
public interface UserDao {

//    @Select("select * from chwo_user where id=#{id}")
    User findUserById(@Param("id") String id);
}
