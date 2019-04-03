package com.onemile.bms.enums;

/**
 * 订单支付状态枚举类
 *
 * @author Eric
 * @date 2018/8/2
 */
public enum OrderPayStatusEnum {

    /**
     * 订单支付状态枚举类
     * 1-待付款，2-付款中，3-付款成功，4-失败待干预'
     */

    WAIT(1, "待付款"),
    PAYING(2, "付款中"),
    SUCCESS(3, "付款成功"),
    FAIL(4, "失败待干预");

    private final int status;
    private String name;

    OrderPayStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    /**
     * 获取代码值
     *
     * @return
     */
    public int status() {
        return status;
    }

    /**
     * 获取名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public static OrderPayStatusEnum of(int val) {
        for (OrderPayStatusEnum statusEnum : values()) {
            if (statusEnum.status() == val) {
                return statusEnum;
            }
        }
        return null;
    }

    public static String toText(Integer val) {
        if (val != null) {
            OrderPayStatusEnum statusEnum = of(val);
            if (statusEnum != null) {
                return statusEnum.name();
            }
        }
        return null;
    }
}
