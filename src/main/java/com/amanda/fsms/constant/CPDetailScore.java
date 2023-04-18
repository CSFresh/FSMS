package com.amanda.fsms.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CPDetailScore {
    private String no;
    private String standard;
    private Integer score;
    private Integer actualScore;
    private Boolean isHighRisk;
    public CPDetailScore(String no,String standard,Integer score,Integer actualScore, Boolean isHighRisk){
        this.no = no;
        this.standard = standard;
        this.score = score;
        this.actualScore = actualScore;
        this.isHighRisk = isHighRisk;
    }
}
