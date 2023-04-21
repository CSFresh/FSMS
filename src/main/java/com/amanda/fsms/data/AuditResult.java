package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jingji
 * @Date: 2023/4/19 23:01
 */
@Getter
@Setter
public class AuditResult {
    private Integer CP;
    private String policy;
    private Integer passCnt = 0;
    private Integer lowRiskFailCnt = 0;
    private Integer middleRiskFailCnt = 0;
    private Integer highRiskFailCnt = 0;
    private Double scoreRate = 0.0;
    private String result;

    public void addLowRiskFailCnt(){
        this.lowRiskFailCnt+=1;
    }

    public void addMiddleRiskFailCnt(){
        this.middleRiskFailCnt+=1;
    }

    public void addHighRiskFailCnt(){
        this.highRiskFailCnt+=1;
    }

    public void addPassCnt(){
        this.passCnt+=1;
    }
}
