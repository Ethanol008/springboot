package com.ruanko.springboothelloworld.service.impl;


import com.ruanko.springboothelloworld.entity.User;
import com.ruanko.springboothelloworld.mapper.UserMapper;
import com.ruanko.springboothelloworld.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;


    public int loginCheck(String name,String password){
//    QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//    queryWrapper.lambda().eq(User::getUserName,name);
//    List<User> userList= userMapper.selectList(queryWrapper);
        List<User> userList= userMapper.loginCheck(name,password);
        if(userList.size()==0){
            return 0;
        }
        if(!(userList.get(0).getPassword().equals(password))){
            return 1;
        }
        return 2;
    }


    public int userRegister(String userName,String password) {
        int n =userMapper.addUser(userName,password);
        return n;
    }

//    @Override
//    public int addUser(User user) {
//
//        return userMapper.addUser(user);
//    }

}
