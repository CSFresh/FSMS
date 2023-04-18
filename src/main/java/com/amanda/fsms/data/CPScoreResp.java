package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CPScoreResp {
    private Integer CP;
    private Boolean success;
    private Double score;
}
