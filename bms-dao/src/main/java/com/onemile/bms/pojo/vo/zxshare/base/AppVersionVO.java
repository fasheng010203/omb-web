package com.onemile.bms.pojo.vo.zxshare.base;

import java.io.Serializable;
import java.util.Date;

public class AppVersionVO  {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 平台  1-ios 2-android 3-wp
     */
    private Integer platform;

    /**
     * 版本号
     */
    private String verison;

    /**
     * 更新描述
     */
    private String description;

    /**
     * 是否需要强制更新  0-否 1-是
     */
    private Integer isForceUpdate;

    /**
     * 下载地址
     */
    private String downUrl;

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
     * 平台  1-ios 2-android 3-wp
     * @return platform 平台  1-ios 2-android 3-wp
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 平台  1-ios 2-android 3-wp
     * @param platform 平台  1-ios 2-android 3-wp
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 版本号
     * @return verison 版本号
     */
    public String getVerison() {
        return verison;
    }

    /**
     * 版本号
     * @param verison 版本号
     */
    public void setVerison(String verison) {
        this.verison = verison == null ? null : verison.trim();
    }

    /**
     * 更新描述
     * @return description 更新描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 更新描述
     * @param description 更新描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否需要强制更新  0-否 1-是
     * @return is_force_update 是否需要强制更新  0-否 1-是
     */
    public Integer getIsForceUpdate() {
        return isForceUpdate;
    }

    /**
     * 是否需要强制更新  0-否 1-是
     * @param isForceUpdate 是否需要强制更新  0-否 1-是
     */
    public void setIsForceUpdate(Integer isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

    /**
     * 下载地址
     * @return down_url 下载地址
     */
    public String getDownUrl() {
        return downUrl;
    }

    /**
     * 下载地址
     * @param downUrl 下载地址
     */
    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl == null ? null : downUrl.trim();
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