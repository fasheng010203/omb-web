package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.util.Date;

public class UserSysMsg implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 消息类型 1-系统类通知 2-订单类通知
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
     * 0-未读 1-已读
     */
    private Integer isRead;

    /**
     * 消息内容指向的url
     */
    private String targetUrl;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 消息类型 1-系统类通知 2-订单类通知
     * @return msg_type 消息类型 1-系统类通知 2-订单类通知
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 消息类型 1-系统类通知 2-订单类通知
     * @param msgType 消息类型 1-系统类通知 2-订单类通知
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
     * 0-未读 1-已读
     * @return is_read 0-未读 1-已读
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 0-未读 1-已读
     * @param isRead 0-未读 1-已读
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 消息内容指向的url
     * @return target_url 消息内容指向的url
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * 消息内容指向的url
     * @param targetUrl 消息内容指向的url
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl == null ? null : targetUrl.trim();
    }

    /**
     * 创建时间
     * @return gmt_create 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}