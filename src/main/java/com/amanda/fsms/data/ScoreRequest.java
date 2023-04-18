package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScoreRequest {
    private List<AreaAndScoreData> areaAndScoreData;
}
