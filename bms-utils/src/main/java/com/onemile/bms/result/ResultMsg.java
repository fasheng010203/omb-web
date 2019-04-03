package com.onemile.bms.result;


import com.onemile.bms.enums.ResultMsgEnum;

/**
 * @author Eric
 */
public class ResultMsg extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -750175880536757644L;

    public final ResultMsgEnum msgEnum;

    /**
     * @param msg
     */
    public ResultMsg(String msg) {
        super(msg);
        this.msgEnum = null;
    }

    public ResultMsg(ResultMsgEnum msgEnum) {
        super(msgEnum.message);
        this.msgEnum = msgEnum;
    }

}
