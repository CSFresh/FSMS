package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AreaDetailScore {

    private String Area;
    private Integer AreaId;
    private List<CPScoreResp> CPScoreRespList = new ArrayList<>();
    private Double areaScore;
    private Integer successCount;
    private Integer failureCount;
}
