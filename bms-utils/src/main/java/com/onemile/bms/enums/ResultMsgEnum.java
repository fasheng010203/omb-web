package com.onemile.bms.enums;

public enum ResultMsgEnum {

    SYSTEM_ERROR(10001, "服务处理异常"),
    SYSTEM_SESSION_INVALID(10004, "用户未登录或超时");

    public final int code;

    public final String message;

    ResultMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
