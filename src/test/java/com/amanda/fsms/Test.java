package com.amanda.fsms;

import com.amanda.fsms.dao.mapper.CPFollowerDetailMapper;
import com.amanda.fsms.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
//        GenerateReportRequest generateReportRequest = new GenerateReportRequest();
//        generateReportRequest.setUserId(123);
//        generateReportRequest.setAuditTeam(new ArrayList<>());
//        List<String> areaList = new ArrayList<>();
//        areaList.add("ADD Restaurant");
//        generateReportRequest.setAuditTeam(areaList);
//        generateReportRequest.setAuditTime(122132131L);
//        generateReportRequest.setAuditType(1);
//        generateReportRequest.setCalcuType(1);
//        generateReportRequest.setEnterprise("中茵皇冠");
//        List<AreaAndScoreData> areaAndScoreDataList = new ArrayList<>();
//        generateReportRequest.setAreaAndScoreDataList(areaAndScoreDataList);
//        AreaAndScoreData areaAndScoreData = new AreaAndScoreData();
//        areaAndScoreDataList.add(areaAndScoreData);
//        areaAndScoreData.setArea("ADD Restaurant");
//        areaAndScoreData.setId(1);
//        List<CPScoreData> cpScoreDataList = new ArrayList<>();
//        areaAndScoreData.setCpScoreDataList(cpScoreDataList);
//        CPScoreData cpScoreData = new CPScoreData();
//        cpScoreData.setCP(1);
//        cpScoreDataList.add(cpScoreData);
//        List<ScoreData> list = new ArrayList<>();
//        cpScoreData.setScoreDataList(list);
//
//        //cp1-1
//        ScoreData scoreData = new ScoreData();
//        scoreData.setAction("N");
//        scoreData.setCP(1);
//        scoreData.setCPNo(1);
//        List<FollowerAndComment> followerAndComments = new ArrayList<>();
//        scoreData.setFollowerAndComments(followerAndComments);
//        FollowerAndComment followerAndComment = new FollowerAndComment();
//        followerAndComment.setComment("脏乱差");
//        List<String> followers = new ArrayList<>();
//        followers.add("收货部");
//        followers.add("工程部");
//        followers.add("ADD Restaurant");
//        followerAndComment.setFollowers(followers);
//        followerAndComment.setNo(1);
//        followerAndComments.add(followerAndComment);
//        list.add(scoreData);
//
//        //cp1-2
//        ScoreData scoreData1 = new ScoreData();
//        scoreData1.setAction("Y");
//        scoreData1.setCP(1);
//        scoreData1.setCPNo(2);
//        list.add(scoreData1);
//        String s = new ObjectMapper().writeValueAsString(generateReportRequest);
//        System.out.println(s);

        String dateStr = "2023/01/02 13:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        try {
            Date date = sf.parse(dateStr);
            System.out.println(date);
            Timestamp t1 = new Timestamp(date.getTime());
            System.out.println(t1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}