package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jingji
 * @Date: 2023/4/23 19:33
 */
@Getter
@Setter
public class UserLoginDTO {

    private Integer userId;
    private String name;
    private String password;
}
