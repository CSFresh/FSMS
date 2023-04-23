package com.amanda.fsms.constant;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CPData {
    private Integer CP;
    private String policy;
    private final List<CPDetailScore> cpDetailScoreList;
    public CPData(){
        cpDetailScoreList = new ArrayList<>();
    }
    private Double finalScore;

    public Double CalculateIndividualScore(){
        Integer score = 0;
        return null;
    }
}
