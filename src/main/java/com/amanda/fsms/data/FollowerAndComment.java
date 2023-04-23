package com.amanda.fsms.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/19 19:20
 */
@Getter
@Setter
public class FollowerAndComment {
    private Integer no;
    private String comment;
    private List<String> followers;
}
