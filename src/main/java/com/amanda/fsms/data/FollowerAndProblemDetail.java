package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/19 22:45
 */
@Getter
@Setter
public class FollowerAndProblemDetail {
    /**
     * 跟进团队
     */
    private String Follower;

    /**
     * 此团队的问题总数
     */
    private Integer problemCnt = 0;

    /**
     * 触犯的具体条例，及问题
     */
    private List<ProblemDetail> problemDetailList = new ArrayList<>();
}
