package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreaAndScoreData {
    private String area;
    private Integer id;
    private List<CPScoreData> cpScoreDataList;
}
