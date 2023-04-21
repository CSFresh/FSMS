package com.amanda.fsms.data;

import lombok.AllArgsConstructor;

/**
 * @author jingji
 * @Date: 2023/4/19 22:37
 */
@AllArgsConstructor
public enum AuditTeam {

    WSJL(1,"卫生经理"),
    GSB(2,"管事部"),
    XZZC(3,"行政总厨"),
    ZJL(4,"总经理"),
    CYZJ(5,"餐饮总监"),
    GCB(6,"工程部"),
    CWB(7,"财务部"),
    KFB(8,"客房部"),
    PXB(9,"培训部"),
    CYB(10,"餐饮部");
    private Integer id;
    private String name;
}
