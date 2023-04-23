package com.amanda.fsms.controller;

import com.amanda.fsms.data.UserData;
import com.amanda.fsms.data.UserLoginData;
import com.amanda.fsms.data.UserLoginResponse;
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
    @PostMapping()
    public UserLoginResponse login(@RequestBody final UserLoginData userLoginData){
        UserData userData = userLoginService.userLogin(userLoginData);
        UserLoginResponse userLoginResponse=  new UserLoginResponse();
        userLoginResponse.setUserData(userData);
        if (userData!=null){
            userLoginResponse.setCode(200);
            userLoginResponse.setMsg("登录成功");
            return userLoginResponse;
        } else{
            userLoginResponse.setCode(500);
            userLoginResponse.setMsg("账号密码校验失败");
            return userLoginResponse;
        }
    }
}
