package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class CPFollowerDetail {

    private String problemId;
    private Integer CP;
    private Integer No;
    private String standard;
    private Integer score;
    private Integer auditScore;
    private String auditRecord;
    private List<String> filesKey;
    private String follower;
    private Long timestamp;
    private String progress;
}
