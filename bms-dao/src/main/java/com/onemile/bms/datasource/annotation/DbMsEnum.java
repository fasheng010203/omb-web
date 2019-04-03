package com.onemile.bms.datasource.annotation;

/**
 * @author Eric
 * 主从库枚举
 */
public enum DbMsEnum {

    BMS("bmsDs"),
    SHARE("shareDs");

    private final String s;

    public String get() {
        return this.s;
    }

    DbMsEnum(String s) {
        this.s = s;
    }
}
