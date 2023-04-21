package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/19 22:40
 */
@Getter
@Setter
public class IndividualReportResponse {

    private List<String> auditTeam;
    private Long auditTime;

    /**
     * 独立计算的报告所需要的所有数据
     */
    private List<Report> reportList = new ArrayList<>();
}
