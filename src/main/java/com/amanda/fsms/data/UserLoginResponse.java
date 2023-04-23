package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {

    private UserData userData;
    private String msg;
    //200没问题  //500错误
    private Integer code;
}
