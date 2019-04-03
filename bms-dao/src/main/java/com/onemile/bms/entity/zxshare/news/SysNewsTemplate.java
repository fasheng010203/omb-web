package com.onemile.bms.entity.zxshare.news;

import java.io.Serializable;
import java.util.Date;

public class SysNewsTemplate implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 模板内容
     */
    private String content;

    /**
     * 状态 0-初始化  1-正常
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
     * 模板名称
     * @return name 模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 模板名称
     * @param name 模板名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 模板内容
     * @return content 模板内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 模板内容
     * @param content 模板内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 状态 0-初始化  1-正常
     * @return status 状态 0-初始化  1-正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0-初始化  1-正常
     * @param status 状态 0-初始化  1-正常
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
}