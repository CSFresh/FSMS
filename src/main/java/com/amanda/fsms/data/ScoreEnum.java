package com.amanda.fsms.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ScoreEnum {

    Y(1, "得分","Y"),
    N(2, "不得分","N"),
    NA(3, "不计分","NA");

    public Integer id;
    private String desc;
    private String action;

    public static ScoreEnum getByAction(
            final String action) {
        for (final ScoreEnum scoreEnum : values()) {
            if (scoreEnum.action == action) {
                return scoreEnum;
            }
        }
        return Y;
    }
}
