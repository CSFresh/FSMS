package com.amanda.fsms.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author jingji
 * @Date: 2023/4/23 14:50
 */
@Setter
@Getter
public class CPFollowerDetailDTO {
    private Integer id;
    private String problemId;
    private Integer CP;
    private Integer No;
    private String area;
    private Integer riskLevel;
    private String follower;
    private Timestamp timestamp;
}
