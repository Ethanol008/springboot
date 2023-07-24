package com.ruanko.springboothelloworld.mapper;


import com.ruanko.springboothelloworld.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{

    @Select("SELECT * FROM user WHERE user_name = #{userName} AND password = #{password}")
    List<User> loginCheck(@Param("userName") String userName, @Param("password") String password);

    @Insert("INSERT INTO user" +
            "        (`user_name`,`password`)" +
            "        VALUES" +
            "            (#{userName},#{password})")
    int addUser(@Param("userName") String userName, @Param("password") String password);

}
