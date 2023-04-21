package com.amanda.fsms.service.impl;

import com.amanda.fsms.constant.CPConstant;
import com.amanda.fsms.constant.CPData;
import com.amanda.fsms.constant.CPDetailScore;
import com.amanda.fsms.constant.FollowerEnum;
import com.amanda.fsms.data.AreaAndScoreData;
import com.amanda.fsms.data.AuditResult;
import com.amanda.fsms.data.CPNoScore;
import com.amanda.fsms.data.CPScoreData;
import com.amanda.fsms.data.FollowerAndComment;
import com.amanda.fsms.data.FollowerAndProblemDetail;
import com.amanda.fsms.data.GenerateReportRequest;
import com.amanda.fsms.data.IndividualReportResponse;
import com.amanda.fsms.data.MergedReportResponse;
import com.amanda.fsms.data.ProblemDetail;
import com.amanda.fsms.data.Report;
import com.amanda.fsms.data.ScoreData;
import com.amanda.fsms.data.ScoreEnum;
import com.amanda.fsms.service.DoWorkService;
import org.springframework.stereotype.Service;

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
        final List<AreaAndScoreData> areaAndScoreDataList =
                generateReportRequest.getAreaAndScoreDataList();
        CPConstant cpConstant = new CPConstant();
        individualReportResponse.setAuditTeam(generateReportRequest.getAuditTeam());
        individualReportResponse.setAuditTime(generateReportRequest.getAuditTime());
        for (AreaAndScoreData areaAndScoreData : areaAndScoreDataList) {
            final List<Report> reportList =
                    individualReportResponse.getReportList();
            Report report = new Report();
            final List<AuditResult> auditResultList = report.getAuditResultList();
            reportList.add(report);
            final List<String> area = report.getArea();
            area.add(areaAndScoreData.getArea());
            final List<CPScoreData> cpScoreDataList = areaAndScoreData.getCpScoreDataList();
            Set<Integer> followerSet = new HashSet<>();
            Integer cpCnt = 0;
            Double finalScore = 0.0;
            Double sumScore = 0.0;
            for (CPScoreData cpScoreData : cpScoreDataList) {
                AuditResult auditResult = new AuditResult();
                auditResultList.add(auditResult);
                final Integer cp = cpScoreData.getCP();
                final CPData cpData = cpConstant.getCpDataList().get(cp - 1);
                //评分标准
                final List<CPDetailScore> cpDetailScoreList = cpData.getCpDetailScoreList();
                final Map<String, CPDetailScore> noToDetailScoreMap =
                        cpDetailScoreList.stream().collect(
                                Collectors.toMap(CPDetailScore::getNo, x -> x));
                final List<ScoreData> scoreList = cpScoreData.getList();
                double score = 0.0;
                Integer totalScore = 0;
                Integer actualScore = 0;
                Boolean succcess = true;
                for (ScoreData scoreData : scoreList) {
                    String scoreKey = cp + "-" + scoreData.getCPNo();
                    final CPDetailScore cpDetailScore = noToDetailScoreMap.get(scoreKey);
                    if (ScoreEnum.getByAction(scoreData.getAction()) == ScoreEnum.Y) {
                        cpCnt += 1;
                        totalScore += cpDetailScore.getScore();
                        actualScore += cpDetailScore.getScore();
                        auditResult.addPassCnt();
                    } else if (ScoreEnum.getByAction(scoreData.getAction()) == ScoreEnum.N) {
                        cpCnt += 1;
                        report.addProblemCnt();
                        totalScore += cpDetailScore.getScore();
                        final List<FollowerAndProblemDetail> followerAndProblemDetailList =
                                report.getFollowerAndProblemDetailList();
                        final List<FollowerAndComment> followerAndComments =
                                scoreData.getFollowerAndComments();
                        //下面这个follow是添加comment信息的，不是得分信息
                        for (FollowerAndComment followerAndComment : followerAndComments) {
                            if (!followerSet.contains(followerAndComment.getFollower())) {
                                FollowerAndProblemDetail followerAndProblemDetail =
                                        new FollowerAndProblemDetail();
                                followerAndProblemDetailList.add(followerAndProblemDetail);
                                followerAndProblemDetail.setFollower(
                                        FollowerEnum.getById(followerAndComment.getFollower())
                                                .name());
                                final List<ProblemDetail> problemDetailList =
                                        followerAndProblemDetail.getProblemDetailList();
                                ProblemDetail problemDetail = new ProblemDetail();
                                String uuid = UUID.randomUUID().toString();
                                problemDetail.setProblemId(uuid);
                                problemDetail.setAuditRecord(followerAndComment.getComment());
                                problemDetail.setAuditScore("N");
                                problemDetail.setCP(cp);
                                problemDetail.setFollower(
                                        FollowerEnum.getById(followerAndComment.getFollower())
                                                .name());
                                problemDetail.setNo(followerAndComment.getNo());
                                problemDetail.setScore(cpDetailScore.getScore());
                                problemDetail.setStandard(cpDetailScore.getStandard());
                                problemDetailList.add(problemDetail);
                                //todo
                                //添加文件
                                final Boolean isHighRisk = cpDetailScore.getIsHighRisk();
                                if (isHighRisk) {
                                    auditResult.addHighRiskFailCnt();
                                    succcess = false;
                                } else if (cpDetailScore.getScore() == 3) {
                                    auditResult.addMiddleRiskFailCnt();
                                } else {
                                    auditResult.addLowRiskFailCnt();
                                }
                                followerAndProblemDetailList.add(followerAndProblemDetail);
                            }
                        }

                    } else {
                        continue;
                    }
                }
                score = actualScore * 1.0 / (totalScore * 1.0);
                sumScore += score;
                if (score < 0.8D) {
                    succcess = false;
                }
                if (succcess) {
                    report.addPassCnt();
                } else {
                    report.addFailCnt();
                }
            }
            finalScore = sumScore / cpCnt;
            report.setFinalScore(finalScore);
        }
        return individualReportResponse;
    }

    @Override
    public MergedReportResponse calculateMerge(
            final GenerateReportRequest generateReportRequest) {
        MergedReportResponse mergedReportResponse = new MergedReportResponse();
        final List<AreaAndScoreData> areaAndScoreDataList =
                generateReportRequest.getAreaAndScoreDataList();
        CPConstant cpConstant = new CPConstant();
        mergedReportResponse.setAuditTeam(generateReportRequest.getAuditTeam());
        mergedReportResponse.setAuditTime(generateReportRequest.getAuditTime());
        Report report = new Report();
        final List<AuditResult> auditResultList = report.getAuditResultList();
        //这个是最终的统计得分，每个区域的实际得分，算分用的。
        Map<Integer, List<CPNoScore>> map = new HashMap<>();
        for (AreaAndScoreData areaAndScoreData : areaAndScoreDataList) {
            Set<Integer> followerSet = new HashSet<>();

            final List<CPScoreData> cpScoreDataList = areaAndScoreData.getCpScoreDataList();
            for (CPScoreData cpScoreData : cpScoreDataList) {
                final Integer cp = cpScoreData.getCP();
                final CPData cpData = cpConstant.getCpDataList().get(cp - 1);
                //评分标准
                final List<CPDetailScore> cpDetailScoreList = cpData.getCpDetailScoreList();
                final Map<String, CPDetailScore> noToDetailScoreMap =
                        cpDetailScoreList.stream().collect(
                                Collectors.toMap(CPDetailScore::getNo, x -> x));
                AuditResult auditResult = new AuditResult();
                auditResultList.add(auditResult);
                final List<ScoreData> list = cpScoreData.getList();
                if (!map.containsKey(cpScoreData.getCP())) {
                    map.put(cpScoreData.getCP(), new ArrayList<>());
                }
                Boolean flag = false;
                final List<CPNoScore> cpNoScores = map.get(cpScoreData.getCP());
                CPNoScore tmpcpNoScore = null;
                for (ScoreData scoreData : list) {
                    Boolean succcess = true;
                    String scoreKey = cp + "-" + scoreData.getCPNo();
                    final CPDetailScore cpDetailScore = noToDetailScoreMap.get(scoreKey);
                    for (CPNoScore cpNoScore : cpNoScores) {
                        if (cpNoScore.getNo() == scoreData.getCPNo()) {
                            tmpcpNoScore = cpNoScore;
                            if (cpNoScore.getActualScore() == 0) {
                                flag = true;
                            }
                            break;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    if (ScoreEnum.getByAction(scoreData.getAction()) == ScoreEnum.Y) {
                        if (tmpcpNoScore != null) {
                            continue;
                        }
                        final List<CPNoScore> cpNoList = map.get(cpScoreData.getCP());
                        CPNoScore cpNoScore = new CPNoScore();
                        cpNoList.add(cpNoScore);
                        cpNoScore.setScore(cpConstant.getCpDataList().get(cpScoreData.getCP() - 1)
                                .getCpDetailScoreList().get(scoreData.getCPNo() - 1).getScore());
                        cpNoScore.setActualScore(cpNoScore.getScore());
                        cpNoScore.setIsHighRisk(cpConstant.getCpDataList().get(
                                cpScoreData.getCP() - 1).getCpDetailScoreList()
                                .get(scoreData.getCPNo() - 1).getIsHighRisk());
                        cpNoScore.setNo(scoreData.getCPNo());
                    } else if (ScoreEnum.getByAction(scoreData.getAction()) == ScoreEnum.N) {
                        if (tmpcpNoScore != null) {
                            tmpcpNoScore.setActualScore(0);
                            continue;
                        }
                        final List<FollowerAndComment> followerAndComments =
                                scoreData.getFollowerAndComments();
                        final List<FollowerAndProblemDetail> followerAndProblemDetailList =
                                report.getFollowerAndProblemDetailList();
                        for (FollowerAndComment followerAndComment : followerAndComments) {
                            if (!followerSet.contains(followerAndComment.getFollower())) {
                                FollowerAndProblemDetail followerAndProblemDetail =
                                        new FollowerAndProblemDetail();
                                followerAndProblemDetailList.add(followerAndProblemDetail);
                                followerAndProblemDetail.setFollower(
                                        FollowerEnum.getById(followerAndComment.getFollower())
                                                .name());
                                final List<ProblemDetail> problemDetailList =
                                        followerAndProblemDetail.getProblemDetailList();
                                ProblemDetail problemDetail = new ProblemDetail();
                                String uuid = UUID.randomUUID().toString();
                                problemDetail.setProblemId(uuid);
                                problemDetail.setAuditRecord(followerAndComment.getComment());
                                problemDetail.setAuditScore("N");
                                problemDetail.setCP(scoreData.getCPNo());
                                problemDetail.setFollower(
                                        FollowerEnum.getById(followerAndComment.getFollower())
                                                .name());
                                problemDetail.setNo(followerAndComment.getNo());
                                problemDetail.setScore(cpDetailScore.getScore());
                                problemDetail.setStandard(cpDetailScore.getStandard());
                                problemDetailList.add(problemDetail);
                                //todo
                                //添加文件
                                final Boolean isHighRisk = cpDetailScore.getIsHighRisk();
                                if (isHighRisk) {
                                    auditResult.addHighRiskFailCnt();
                                    succcess = false;
                                } else if (cpDetailScore.getScore() == 3) {
                                    auditResult.addMiddleRiskFailCnt();
                                } else {
                                    auditResult.addLowRiskFailCnt();
                                }
                                followerAndProblemDetailList.add(followerAndProblemDetail);
                            }
                        }
                        final List<CPNoScore> cpNoList = map.get(cpScoreData.getCP());
                        CPNoScore cpNoScore = new CPNoScore();
                        cpNoList.add(cpNoScore);
                        cpNoScore.setScore(cpConstant.getCpDataList().get(cpScoreData.getCP() - 1)
                                .getCpDetailScoreList().get(scoreData.getCPNo() - 1).getScore());
                        cpNoScore.setActualScore(0);
                        cpNoScore.setIsHighRisk(cpConstant.getCpDataList().get(
                                cpScoreData.getCP() - 1).getCpDetailScoreList()
                                .get(scoreData.getCPNo() - 1).getIsHighRisk());
                        cpNoScore.setNo(scoreData.getCPNo());
                    }
                }
            }
        }

    }

    @Override
    public IndividualReportResponse calculateMonthlyMerge(
            final GenerateReportRequest generateReportRequest) {
        return null;
    }
}
