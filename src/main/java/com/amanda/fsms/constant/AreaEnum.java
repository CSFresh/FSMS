package com.amanda.fsms.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.UNKNOWN;

/**
 * @author jingji
 * @Date: 2023/4/18 19:14
 */
@AllArgsConstructor
@Getter
public enum AreaEnum {

    ADD_RESTAURANT(1,"ADD Restaurant"),
    ADD_KITCHEN(2,"ADD Kitchen"),
    LOBBY_BAR(3,"Lobby Bar"),
    STAFF_CANTEEN(4,"Staff Canteen"),
    TEAHOUSE(5,"Teahouse"),
    BUTCHER(6,"Butcher"),
    BANQUET_RESTAURANT(7,"Banquet Restaurant"),
    BANQUET_KITCHEN(8,"Banquet Kitchen"),
    PASTRY(9,"Pastry"),
    CHINESE_RESTAURANT(10,"Chinese Restaurant"),
    CHINESE_KITCHEN(11,"Chinese Kitchen"),
    HSKP(12,"HSKP"),
    EXECUTIVE_LOUNGE(13,"Executive Lounge"),
    RECEIVING(14,"Receiving"),
    GARBAGE_CHAMBER(15,"Receiving"),
    CHEMICAL_WAREHOUSE(16,"Chemical warehouse"),
    OTHER(17,"Other"),
    UNKNOWN(18,"Unknown");
    private Integer id;
    private String area;
    public static AreaEnum getAreaIdByArea(final String area) {
        for (final AreaEnum areaEnum : AreaEnum.values()) {
            if (areaEnum.area.equals(area) ) {
                return areaEnum;
            }
        }
        return UNKNOWN;
    }
}
