package com.onemile.bms.entity.zxshare.base;

import java.io.Serializable;

/**
 * @author Eric
 */
public class SysMsgTemplate implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 消息类型 1-实名认证 2-银行卡认证 3 -订单  4-提现 5-信息发布
     */
    private Integer msgType;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 消息打开的url
     */
    private String msgUrl;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 消息类型 1-实名认证 2-银行卡认证 3 -订单  4-提现 5-信息发布
     * @return msg_type 消息类型 1-实名认证 2-银行卡认证 3 -订单  4-提现 5-信息发布
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 消息类型 1-实名认证 2-银行卡认证 3 -订单  4-提现 5-信息发布
     * @param msgType 消息类型 1-实名认证 2-银行卡认证 3 -订单  4-提现 5-信息发布
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * 消息标题
     * @return msg_title 消息标题
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 消息标题
     * @param msgTitle 消息标题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    /**
     * 消息内容
     * @return msg_content 消息内容
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 消息内容
     * @param msgContent 消息内容
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    /**
     * 消息打开的url
     * @return msg_url 消息打开的url
     */
    public String getMsgUrl() {
        return msgUrl;
    }

    /**
     * 消息打开的url
     * @param msgUrl 消息打开的url
     */
    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl == null ? null : msgUrl.trim();
    }

    @Override
    public String toString() {
        return "SysMsgTemplate{" +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgTitle='" + msgTitle + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", msgUrl='" + msgUrl + '\'' +
                '}';
    }
}