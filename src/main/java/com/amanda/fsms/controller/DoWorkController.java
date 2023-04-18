package com.amanda.fsms.controller;

import com.amanda.fsms.constant.CPConstant;
import com.amanda.fsms.constant.CPData;
import com.amanda.fsms.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/audit")
public class DoWorkController {


    @GetMapping("/area")
    public List<AreaData> getAreaOfHotel(){
        System.out.println("123");
        return null;
    }


    @GetMapping("/start")
    public CPConstant runAudit(Integer userId){
        CPConstant cpConstant = new CPConstant();
        return cpConstant;
    }

    @GetMapping("/individual")
    public AreaScoreResponse calculateIndividual(ScoreRequest scoreRequest){
        CPConstant cpConstant = new CPConstant();
        List<AreaAndScoreData> areaAndScoreDataList = scoreRequest.getAreaAndScoreData();
        List<Double> cpScoreList = new ArrayList<>();
        AreaScoreResponse response = new AreaScoreResponse();
        List<AreaDetailScore> areaDetailScoreList = response.getAreaDetailScoreList();
        for (AreaAndScoreData areaAndScoreData:areaAndScoreDataList){
            AreaDetailScore areaDetailScore = new AreaDetailScore();
            List<CPScoreResp> cpScoreRespList = areaDetailScore.getCPScoreRespList();
            String area = areaAndScoreData.getArea();
            Integer id = areaAndScoreData.getId();
            areaDetailScore.setArea(area);
            areaDetailScore.setAreaId(id);
            List<CPScoreData> cpScoreDataList = areaAndScoreData.getCpScoreDataList();
            Double sumScore = 0.0;
            Integer successCount = 0;
            Integer failureCount = 0;
            for (CPScoreData cpScoreData:cpScoreDataList){
                int sum = 0;
                Boolean success = true;
                int actualScore = 0;
                List<ScoreData> list = cpScoreData.getList();
                CPScoreResp cpScoreResp = new CPScoreResp();
                for (int i = 0;i<list.size();++i){
                    if (ScoreEnum.getByAction(list.get(i).getAction())==ScoreEnum.Y){
                        Integer s = cpConstant.getCpDataList().get(cpScoreData.getCP()).getCpDetailScoreList().get(i).getScore();
                        sum+=s;
                        actualScore +=s;
                    } else if (ScoreEnum.getByAction(list.get(i).getAction())==ScoreEnum.N){
                        Boolean isHighRisk = cpConstant.getCpDataList().get(cpScoreData.getCP()).getCpDetailScoreList().get(i).getIsHighRisk();
                        if (isHighRisk){
                            success = false;
                        }
                        Integer s = cpConstant.getCpDataList().get(cpScoreData.getCP()).getCpDetailScoreList().get(i).getScore();
                        sum+=s;
                    } else {
                        continue;
                    }
                }
                double score = actualScore*1.0/sum*1.0;
                success = success&&(score>=0.8);
                if (success){
                    successCount++;
                } else{
                    failureCount++;
                }
                sumScore+=score;
                cpScoreList.add(score);
                cpScoreResp.setCP(cpScoreData.getCP());
                cpScoreResp.setScore(score);
                cpScoreResp.setSuccess(success);
                cpScoreRespList.add(cpScoreResp);
            }
            areaDetailScore.setFailureCount(failureCount);
            areaDetailScore.setSuccessCount(successCount);
            areaDetailScore.setAreaScore(sumScore/(failureCount+successCount));
            areaDetailScoreList.add(areaDetailScore);
        }
        return response;
    }

    @GetMapping("merge")
    public Double calculateMergeScore(ScoreRequest scoreRequest){
        return null;
    }
}
