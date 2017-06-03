package com.cw.shwo.mapper;

import com.cw.chwo.module.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by handl on 2017/6/3.
 */
@Mapper
public interface UserDao {

    @Select("select * from chwo_user where id=#{id}")
    User findUserById(String id);
}
