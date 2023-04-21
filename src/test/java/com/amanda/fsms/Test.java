package com.amanda.fsms;

import com.amanda.fsms.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        GenerateReportRequest generateReportRequest = new GenerateReportRequest();
        generateReportRequest.setUserId(123);
        generateReportRequest.setAuditTeam(new ArrayList<>());
        List<String> areaList = new ArrayList<>();
        areaList.add("123");
        areaList.add("321");
        generateReportRequest.setAuditTeam(areaList);
        generateReportRequest.setAuditTime(122132131L);
        generateReportRequest.setAuditType(1);
        generateReportRequest.setCalcuType(1);
        generateReportRequest.setEnterprise("中因皇冠");
        List<AreaAndScoreData> areaAndScoreDataList = new ArrayList<>();
        generateReportRequest.setAreaAndScoreDataList(areaAndScoreDataList);
        AreaAndScoreData areaAndScoreData = new AreaAndScoreData();
        areaAndScoreDataList.add(areaAndScoreData);
        areaAndScoreData.setArea("厨房");
        areaAndScoreData.setId(1);
        List<CPScoreData> cpScoreDataList = new ArrayList<>();
        areaAndScoreData.setCpScoreDataList(cpScoreDataList);
        CPScoreData cpScoreData = new CPScoreData();
        cpScoreData.setCP(1);
        cpScoreDataList.add(cpScoreData);
        List<ScoreData> list = new ArrayList<>();
        cpScoreData.setList(list);

        //cp1-1
        ScoreData scoreData = new ScoreData();
        scoreData.setAction("N");
        scoreData.setCP(1);
        scoreData.setCPNo(1);
        List<FollowerAndComment> followerAndComments = new ArrayList<>();
        scoreData.setFollowerAndComments(followerAndComments);
        FollowerAndComment followerAndComment = new FollowerAndComment();
        followerAndComment.setComment("不好");
        followerAndComment.setFollower("厨房");
        followerAndComment.setNo(1);
        followerAndComments.add(followerAndComment);
        list.add(scoreData);

        //cp1-2
        ScoreData scoreData1 = new ScoreData();
        scoreData1.setAction("Y");
        scoreData1.setCP(1);
        scoreData1.setCPNo(2);
        list.add(scoreData1);
        String s = new ObjectMapper().writeValueAsString(generateReportRequest);
        System.out.println(s);
    }
}