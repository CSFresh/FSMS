package com.amanda.fsms.service;

import com.amanda.fsms.data.GenerateReportRequest;
import com.amanda.fsms.data.IndividualReportResponse;
import com.amanda.fsms.data.MergedReportResponse;

public interface DoWorkService {
    IndividualReportResponse calculateIndividual(GenerateReportRequest generateReportRequest);
    MergedReportResponse calculateMerge(GenerateReportRequest generateReportRequest);
    MergedReportResponse calculateMonthlyMerge(GenerateReportRequest generateReportRequest);
}
