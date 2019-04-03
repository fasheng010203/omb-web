package com.onemile.bms.enums;

/**
 * 租赁信息类型枚举类
 *
 * @author Eric
 * @date 2018/8/2
 */
public enum OrderTypeEnum {

    /**
     * 租赁信息类型枚举类
     */

    NORMAL(1, "普通购物型"),
    TRANSPORT(2, "钢管等带车辆运输型");

    private final int type;
    private String name;

    OrderTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 获取代码值
     *
     * @return
     */
    public int type() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static OrderTypeEnum of(int val) {
        for (OrderTypeEnum typeEnum : values()) {
            if (typeEnum.type() == val) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String toText(Integer val) {
        if (val != null) {
            OrderTypeEnum typeEnum = of(val);
            if (typeEnum != null) {
                return typeEnum.name();
            }
        }
        return null;
    }
}
