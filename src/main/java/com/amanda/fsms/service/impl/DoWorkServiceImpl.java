package com.amanda.fsms.service.impl;

import com.amanda.fsms.constant.CPConstant;
import com.amanda.fsms.constant.CPData;
import com.amanda.fsms.constant.CPDetailScore;
import com.amanda.fsms.constant.FollowerEnum;
import com.amanda.fsms.data.*;
import com.amanda.fsms.service.DoWorkService;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Service;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author jingji
 * @Date: 2023/4/19 20:10
 */
@Service
public class DoWorkServiceImpl implements DoWorkService {

    @Override
    public IndividualReportResponse calculateIndividual(
            final GenerateReportRequest generateReportRequest) {
        IndividualReportResponse individualReportResponse = new IndividualReportResponse();
        individualReportResponse.setAuditTeam(generateReportRequest.getAuditTeam());//审核团队
        individualReportResponse.setAuditTime(generateReportRequest.getAuditTime());//审核时间
        List<AreaAndScoreData> areaAndScoreDataList = generateReportRequest.getAreaAndScoreDataList();
        CPConstant cpConstant = new CPConstant();
        for (AreaAndScoreData areaAndScoreData:areaAndScoreDataList){
            Report report = new Report();
            //日审报告auditArea
            List<String> area = report.getArea();
            area.add(areaAndScoreData.getArea());
            //每个区域的低风险、高风险、中风险数量以及得分。
            List<AuditResult> auditResultList = report.getAuditResultList();
            //CPList Cp1到Cp19
            List<CPScoreData> cpScoreDataList = areaAndScoreData.getCpScoreDataList();
            //已添加
            List<CPFollowerDetail> cpFollowerDetailList = report.getCpFollowerDetailList();
            Integer cpCount = 0;
            Double sumScore = 0.0;
            for (CPScoreData cpScoreData:cpScoreDataList){
                //遍历小cp点的时候每次有问题就+1  已经添加到report里了，不用担心没加
                AuditResult auditResult = new AuditResult();
                auditResultList.add(auditResult);
                Integer cp = cpScoreData.getCP();
                auditResult.setCP(cp);
                //CP1 CP2
                CPData cpData = cpConstant.getCpDataList().get(cp - 1);
                Double CPScore = 0.0;
                Integer totalScore = 0;//有效Cp点的总分值
                Integer actualScore = 0;//有效cp点的实际得分
                //每一个cpNo点 比如cp1-1 cp1-2 cp1-3
                List<ScoreData> cpNoList = cpScoreData.getList();
                //算每个CP点的得分
                for (ScoreData scoreData:cpNoList){
                    //CP1-1 CP1-2
                    CPDetailScore cpDetailScore = cpData.getCpDetailScoreList().get(scoreData.getCPNo() - 1);
                    if (scoreData.getAction()=="Y"){
                        totalScore+=cpDetailScore.getScore();
                        actualScore+=cpDetailScore.getScore();
                        auditResult.addPassCnt();
                    } else if (scoreData.getAction()=="N"){
                        totalScore+=cpDetailScore.getScore();
                        //下面开始添加评论
                        cpFollowerDetailList.addAll(convert(scoreData,cpDetailScore.getScore(),0,cpDetailScore.getStandard(), new ArrayList<>(),report));
                        if (cpDetailScore.getIsHighRisk()){
                            auditResult.addHighRiskFailCnt();
                            auditResult.setResult("fail");
                        } else if (cpDetailScore.getScore()==3){
                            auditResult.addMiddleRiskFailCnt();
                        } else{
                            auditResult.addLowRiskFailCnt();
                        }
                    }
                }
                CPScore = actualScore*1.0/totalScore*1.0;
                auditResult.setScoreRate(CPScore);
                if (!auditResult.getResult().equals("fail")){
                    auditResult.setResult(CPScore>=0.8?"pass":"fail");
                }
                if (auditResult.getResult().equals("pass")){
                    report.addPassCnt();
                } else {
                    report.addFailCnt();
                }
                sumScore+=auditResult.getScoreRate();
                cpCount++;
            }
            if (cpCount!=0){
                report.setFinalScore(sumScore/cpCount*1.0);
            }
        }
        return individualReportResponse;
    }

    @Override
    public MergedReportResponse calculateMerge(GenerateReportRequest generateReportRequest) {
        return null;
    }

    @Override
    public MergedReportResponse calculateMonthlyMerge(GenerateReportRequest generateReportRequest) {
        return null;
    }


    private List<CPFollowerDetail> convert(ScoreData scoreData,Integer score,Integer auditScore,String standard,List<String> path,Report report){
        List<FollowerAndComment> followerAndComments = scoreData.getFollowerAndComments();
        List<CPFollowerDetail> list = new ArrayList<>();
        for (FollowerAndComment followerAndComment:followerAndComments){
            CPFollowerDetail cpFollowerDetail = new CPFollowerDetail();
            cpFollowerDetail.setAuditRecord(followerAndComment.getComment());
            cpFollowerDetail.setAuditScore(auditScore);
            cpFollowerDetail.setCP(scoreData.getCP());
            cpFollowerDetail.setFollower(followerAndComment.getFollower());
            report.addFollowerProblemCnt(followerAndComment.getFollower());
            report.addProblemCnt();
            cpFollowerDetail.setNo(scoreData.getCPNo());
            cpFollowerDetail.setScore(score);
            cpFollowerDetail.setStandard(standard);
            cpFollowerDetail.setProblemId(UUID.randomUUID().toString());
            cpFollowerDetail.setFilesKey(path);
            list.add(cpFollowerDetail);
        }
        return list;
    }
}
