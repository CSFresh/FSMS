package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author jingji
 * @Date: 2023/4/19 22:58
 */
@Getter
@Setter
public class CPScoreAndPassCnt {

    private Double score;
    private Integer CPCnt;
    private Timestamp timestamp;
}
