package com.onemile.bms.pojo.dto.device;

/**
 * @author ericma
 */
public class OneNetReqDTO {

    private String msg;
    private String nonce;
    private String signature;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) { this.msg = msg; }
    public String getNonce() {
        return nonce;
    }
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
