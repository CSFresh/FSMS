package com.amanda.fsms.data;

import com.amanda.fsms.constant.CPData;
import com.amanda.fsms.constant.CPDetailScore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/23 16:23
 */
@Getter
@Setter
public class AreaAndCPResp {

    private Integer area;
    private List<CPData> cpDataList;

}
