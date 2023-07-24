package com.ruanko.springboothelloworld.controller;

import com.ruanko.springboothelloworld.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/success")
    public ModelAndView loginSuccess(){
        return new ModelAndView("success");
    }

    @RequestMapping("/register")
    public ModelAndView goRegister(){
        return new ModelAndView("register");
    }


    @RequestMapping("/userRegister")
    public ModelAndView userRegister(String userName,String password){
        int n =userService.userRegister(userName,password);
        return new ModelAndView("index");
    }

//    @ResponseBody
    @RequestMapping("/userLogin")
    public ModelAndView userLogin(String userName,String password){
        int n= userService.loginCheck(userName,password);
        if(n==2){
            return new  ModelAndView("success");
        }
        return new  ModelAndView("index");
    }
}