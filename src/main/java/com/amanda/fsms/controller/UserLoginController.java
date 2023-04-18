package com.amanda.fsms.controller;

import com.amanda.fsms.data.UserData;
import com.amanda.fsms.data.UserLoginData;
import com.amanda.fsms.service.UserLoginService;
import com.amanda.fsms.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
//    public void login(@RequestBody UserLoginData userLoginData){
    @GetMapping("login")
    public void login(){
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setUserName("Amanda");
        userLoginData.setPassword("1105700");
        UserData userData = userLoginService.userLogin(userLoginData);
    }
}
