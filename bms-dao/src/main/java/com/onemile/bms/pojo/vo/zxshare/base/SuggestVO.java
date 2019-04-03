package com.onemile.bms.pojo.vo.zxshare.base;

import java.io.Serializable;
import java.util.Date;

public class SuggestVO   {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 建议类型  1-默认  其他暂未定义
     */
    private Integer suggestType;

    /**
     * 联系手机号码
     */
    private String mobile;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态  0-未处理  1-已处理  2-暂不处理
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    private String   nickName;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
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
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 建议类型  1-默认  其他暂未定义
     * @return suggest_type 建议类型  1-默认  其他暂未定义
     */
    public Integer getSuggestType() {
        return suggestType;
    }

    /**
     * 建议类型  1-默认  其他暂未定义
     * @param suggestType 建议类型  1-默认  其他暂未定义
     */
    public void setSuggestType(Integer suggestType) {
        this.suggestType = suggestType;
    }

    /**
     * 联系手机号码
     * @return mobile 联系手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 联系手机号码
     * @param mobile 联系手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 状态  0-未处理  1-已处理  2-暂不处理
     * @return status 状态  0-未处理  1-已处理  2-暂不处理
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  0-未处理  1-已处理  2-暂不处理
     * @param status 状态  0-未处理  1-已处理  2-暂不处理
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}