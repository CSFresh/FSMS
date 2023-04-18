package com.amanda.fsms.service;


import com.amanda.fsms.data.UserData;
import com.amanda.fsms.data.UserLoginData;

public interface UserLoginService {

    UserData userLogin(UserLoginData userLoginData);
}
