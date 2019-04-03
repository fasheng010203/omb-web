package com.onemile.bms.enums;

/**
 * 租赁信息类型枚举类
 *
 * @author Eric
 * @date 2018/8/2
 */
public enum OrderPayTypeEnum {

    /**
     * 租赁信息类型枚举类
     */

    ALIPAY(1, "支付宝"),
    WEIXIN(2, "微信"),
    ACCOUNT(3, "账户支付"),
    OFFLINE(4, "线下支付"),
    BANK(5, "网银支付");

    private final int type;
    private String name;

    OrderPayTypeEnum(int type, String name) {
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

    public static OrderPayTypeEnum of(int val) {
        for (OrderPayTypeEnum typeEnum : values()) {
            if (typeEnum.type() == val) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String toText(Integer val) {
        if (val != null) {
            OrderPayTypeEnum typeEnum = of(val);
            if (typeEnum != null) {
                return typeEnum.name();
            }
        }
        return null;
    }
}
