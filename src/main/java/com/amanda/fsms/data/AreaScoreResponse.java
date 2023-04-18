package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AreaScoreResponse {
    private List<AreaDetailScore> areaDetailScoreList = new ArrayList<>();
}

