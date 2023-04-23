package com.amanda.fsms.dao.mapper;

import com.amanda.fsms.data.UserLoginData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
@Mapper
public interface UserLoginMapper {
    @Select("SELECT * FROM userLogin where `name` =#{name} and `password` =#{password}")
    UserLoginData selectUser(String userName, String password);
}
