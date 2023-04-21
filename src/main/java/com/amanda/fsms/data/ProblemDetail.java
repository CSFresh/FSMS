package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jingji
 * @Date: 2023/4/19 22:48
 */
@Getter
@Setter
public class ProblemDetail {
    private String problemId;
    private Integer CP;
    private Integer No;
    private String standard;
    private Integer score;
    private String auditScore;
    private String auditRecord;
    private List<File> files;
    private String follower;
    private Timestamp timestamp;
    private String progress;
}
