package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jingji
 * @Date: 2023/4/19 22:41
 */
@Getter
@Setter
public class Report {

    /**
     * 审核范围 单独出报告，所以只有一个
     */
    private List<String> area = new ArrayList<>();

    /**
     * 待跟进的问题总数
     */
    private Integer problemCount;

    /**
     * 最终分数
     */
    private Double finalScore;

    /**
     *
     */
    private Map<String,Integer> followerProblemCntMap = new HashMap<>();

    /**
     * 出问题的具体细节及相应的跟进人
     */
    private List<FollowerAndProblemDetail> followerAndProblemDetailList = new ArrayList<>();

    /**
     * 出问题的CP点和具体的跟进人
     */
    private List<CPFollowerDetail> cpFollowerDetailList = new ArrayList<>();

    /**
     * 最近三次的审核结果
     * Score CP Time
     */
    private List<CPScoreAndPassCnt> cpScoreAndPassCntList = new ArrayList<>();
    /**
     * 展示分数的部分，通过这个拿到
     */
    private List<AuditResult> auditResultList = new ArrayList<>();
    /**
     * 该区域通过的CP数
     */
    private Integer passCnt;
    /**
     * 该区域失败的CP数
     */
    private Integer failCnt;

    public void addPassCnt(){
        this.passCnt+=1;
    }

    public void addFailCnt(){
        this.failCnt+=1;
    }

    public void addProblemCnt(){
        this.problemCount+=1;
    }

    public void addFollowerProblemCnt(String follower){
        followerProblemCntMap.put(follower,followerProblemCntMap.getOrDefault(follower,1)+1);
    }

}
