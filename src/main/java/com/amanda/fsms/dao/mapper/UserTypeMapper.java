package com.amanda.fsms.dao.mapper;

import com.amanda.fsms.data.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserTypeMapper {
    @Select("SELECT * FROM userType where `userId` =#{userId}")
    UserData selectByUserId(Integer userId);
}
