package com.onemile.bms.enums;

/**
 * 订单评价状态枚举类
 *
 * @author Eric
 * @date 2018/8/2
 */
public enum OrderEstimateStatusEnum {

    /**
     * 订单评价状态枚举类
     * 0-未评价  1-买家已评价  2-卖家已评价 3-双方已评价'
     */

    WAIT(0, "未评价"),
    BUYER(1, "买家已评价"),
    SELLER(2, "卖家已评价"),
    FINISH(3, "双方已评价");

    private final int status;
    private String name;

    OrderEstimateStatusEnum(int status, String name) {
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

    public static OrderEstimateStatusEnum of(int val) {
        for (OrderEstimateStatusEnum statusEnum : values()) {
            if (statusEnum.status() == val) {
                return statusEnum;
            }
        }
        return null;
    }

    public static String toText(Integer val) {
        if (val != null) {
            OrderEstimateStatusEnum statusEnum = of(val);
            if (statusEnum != null) {
                return statusEnum.name();
            }
        }
        return null;
    }
}
