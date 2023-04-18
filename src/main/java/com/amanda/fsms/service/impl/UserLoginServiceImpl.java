package com.amanda.fsms.service.impl;

import com.amanda.fsms.dao.mapper.UserTypeMapper;
import com.amanda.fsms.dao.mapper.UserLoginMapper;
import com.amanda.fsms.data.UserData;
import com.amanda.fsms.data.UserLoginData;
import com.amanda.fsms.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private UserTypeMapper userTypeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public UserData userLogin(UserLoginData user) {

        UserLoginData userLoginData = userLoginMapper.selectUser(user.getUserName(), user.getPassword());
        if (userLoginData==null){
            return null;
        }
        UserData userData = userTypeMapper.selectByUserId(userLoginData.getId());
        return userData;
    }
}
