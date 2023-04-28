package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/19 23:11
 */
@Getter
@Setter
public class GenerateReportRequest {

    private Integer userId;
    private String auditId;
    private String enterprise;
    private Long auditTime;
    /**
     * 1 月审
     * 2 日审
     */
    private Integer auditType;
    private List<String> auditTeam;
    private List<AreaAndScoreData> areaAndScoreDataList;
    /**
     * 1 分开
     * 2 合并
     */
    private Integer calcuType;
}
