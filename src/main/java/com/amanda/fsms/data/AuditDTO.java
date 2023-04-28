package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author jingji
 * @Date: 2023/4/20 16:03
 */
@Getter
@Setter
public class AuditDTO {

    private Integer id;
    private String auditId;
    private String auditName;
    private String dataKey;
    private Integer userId;
    private Boolean deleted;
    private Timestamp created;
    private Timestamp lastModified;
}
