package com.amanda.fsms.constant;

import com.amanda.fsms.data.ScoreEnum;
import lombok.AllArgsConstructor;

/**
 * @author jingji
 * @Date: 2023/4/19 17:09
 */

@AllArgsConstructor
public enum FollowerEnum {
    ADD_RESTAURANT(1, "ADD Restaurant"),
    ADD_KITCHEN(2, "ADD Kitchen"),
    LOBBY_BAR(3, "Lobby Bar"),
    STAFF_CANTEEN(4, "Staff Canteen"),
    TEAHOUSE(5, "Teahouse"),
    BUTCHER(6, "Butcher"),
    BANQUET_RESTAURANT(7, "Banquet Restaurant"),
    BANQUET_KITCHEN(8, "Banquet Kitchen"),
    PASTRY(9, "Pastry"),
    CHINESE_RESTAURANT(10, "Chinese Restaurant"),
    CHINESE_KITCHEN(11, "Chinese Kitchen"),
    HSKP(12, "HSKP"),
    EXECUTIVE_LOUNGE(13, "Executive Lounge"),
    RECEIVING(14, "Receiving"),
    GARBAGE_CHAMBER(15, "Receiving"),
    CHEMICAL_WAREHOUSE(16, "Chemical warehouse"),
    OTHER(17, "Other"),
    GONGCHENG(18, "工程部"),
    GUANSHI(19, "管事部"),
    CAIGOU(20, "采购部"),
    SHOUHUO(21, "收获部"),
    PA(22, "PA"),
    PEIXUN(23, "培训部");
    private Integer id;
    private String name;

    public static FollowerEnum getById(
            final Integer id) {
        for (final FollowerEnum followerEnum : values()) {
            if (followerEnum.id == id) {
                return followerEnum;
            }
        }
        return null;
    }
}
