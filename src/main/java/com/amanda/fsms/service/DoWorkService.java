package com.amanda.fsms.service;

import com.amanda.fsms.data.AreaAndCPResp;
import com.amanda.fsms.data.AreaData;
import com.amanda.fsms.data.CPAreaResponse;
import com.amanda.fsms.data.GenerateReportRequest;
import com.amanda.fsms.data.IndividualReportResponse;
import com.amanda.fsms.data.MergedReportResponse;

import java.util.List;

public interface DoWorkService {
    IndividualReportResponse calculateIndividual(GenerateReportRequest generateReportRequest);
    CPAreaResponse getCPInfo(List<String> area);
    List<AreaData> getAllArea();
    MergedReportResponse calculateMerge(GenerateReportRequest generateReportRequest);
    MergedReportResponse calculateMonthlyMerge(GenerateReportRequest generateReportRequest);
    String insertAudit();
}
