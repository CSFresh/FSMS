package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jingji
 * @Date: 2023/4/20 16:03
 */
@Getter
@Setter
public class AuditDTO {

    private Integer id;
    private String auditDataKey;
    private Integer authorId;
}
