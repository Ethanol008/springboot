package com.ruanko.springboothelloworld.service;


public interface UserService {

   int loginCheck(String name, String password);

   int userRegister(String userName, String password);



//    public int addUser(User user);



}
