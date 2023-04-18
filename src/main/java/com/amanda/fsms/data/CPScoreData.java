package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CPScoreData {
    private Integer CP;
    private List<ScoreData> list;
}
