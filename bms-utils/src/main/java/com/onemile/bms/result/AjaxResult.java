package com.onemile.bms.result;
import com.onemile.bms.enums.ResultMsgEnum;

/**
 * @author Eric
 */
public class AjaxResult {
    public static final int CODE_SUCCESS = 0;

    public static final int CODE_FAILED = 1;

    private int code;

    private String message;

    private Object data;

    private AjaxResult(Integer code, Object data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public boolean isSuccess() {
        return CODE_SUCCESS == code;
    }

    public static final AjaxResult success() {
        return new AjaxResult(CODE_SUCCESS, null, null);
    }

    public static final AjaxResult success(Object data) {
        return new AjaxResult(CODE_SUCCESS, data, null);
    }

    public static final AjaxResult success(Object data, String message) {
        return new AjaxResult(CODE_SUCCESS, data, message);
    }

    public static final AjaxResult success(ResultMsgEnum r, Object data) {
        return new AjaxResult(r.code, data, r.message);
    }

    public static final AjaxResult failed() {
        return new AjaxResult(CODE_FAILED, null, null);
    }

    public static final AjaxResult failed(String message) {
        return new AjaxResult(CODE_FAILED, null, message);
    }

    public static final AjaxResult failed(Object data, String message) {
        return new AjaxResult(CODE_FAILED, data, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static final AjaxResult failed(ResultMsgEnum err) {
        return new AjaxResult(err.code, null, err.message);
    }

    public static final AjaxResult failed(ResultMsg err) {
        if (err.msgEnum != null) {
            return new AjaxResult(err.msgEnum.code, null, err.msgEnum.message);
        }
        return new AjaxResult(CODE_FAILED, null, err.getMessage());
    }

}
