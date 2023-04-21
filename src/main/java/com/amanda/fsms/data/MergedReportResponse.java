package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/20 22:26
 */
@Getter
@Setter
public class MergedReportResponse {
    private List<String> auditTeam;
    private String auditTime;
    private List<String> area;
    private Report report;
}
