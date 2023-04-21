package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jingji
 * @Date: 2023/4/20 16:31
 */
@Getter
@Setter
public class DepartmentAuditDTO {

    private Integer id;
    private String auditId;
    private Integer departmentId;
    private String auditIdName;
}
