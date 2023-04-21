package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jingji
 * @Date: 2023/4/20 23:41
 */
@Getter
@Setter
public class CPNoScore {

    private Integer no;
    private String standard;
    private Integer score;
    private Integer actualScore;
    private Boolean isHighRisk;
}
