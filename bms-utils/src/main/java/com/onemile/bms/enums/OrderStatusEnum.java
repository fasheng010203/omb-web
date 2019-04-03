package com.onemile.bms.enums;

/**
 * 订单状态枚举类
 *
 * @author Eric
 * @date 2018/8/2
 */
public enum OrderStatusEnum {

    /**
     * 1-待确认单价、2-待提货、 3-待装卸、 4-待支付 、5-待卖家确认、 6-待发货、 7-待收货、 8-已完成、9-退款中、10-退款成功、99-交易已关闭',
     * 订单状态枚举类
     */

    PRICE(1, "待确认单价"),
    TAKE(2, "待提货"),
    ZX(3, "待装卸"),
    PAY(4, "待支付"),
    SALEERCONFIRM(5, "待卖家确认"),
    SEND(6, "待发货"),
    RECIVER(7, "待收货"),
    SUCCESS(8, "已完成"),
    REFUND(9, "退款中"),
    REFUNDSUCCESS(10, "退款成功"),
    CLOSED(99, "交易已关闭");

    private final int status;
    private String name;

    OrderStatusEnum(int status, String name) {
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

    public static OrderStatusEnum of(int val) {
        for (OrderStatusEnum statusEnum : values()) {
            if (statusEnum.status() == val) {
                return statusEnum;
            }
        }
        return null;
    }

    public static String toText(Integer val) {
        if (val != null) {
            OrderStatusEnum statusEnum = of(val);
            if (statusEnum != null) {
                return statusEnum.name();
            }
        }
        return null;
    }
}
