package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

public class AdminCity implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userid;

    /**
     * 用户管理城市
     */
    private String usercity;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 修改人
     */
    private Long updateOperId;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户ID
     * @return userid 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 用户ID
     * @param userid 用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 用户管理城市
     * @return usercity 用户管理城市
     */
    public String getUsercity() {
        return usercity;
    }

    /**
     * 用户管理城市
     * @param usercity 用户管理城市
     */
    public void setUsercity(String usercity) {
        this.usercity = usercity == null ? null : usercity.trim();
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

    /**
     * 修改人
     * @return update_oper_id 修改人
     */
    public Long getUpdateOperId() {
        return updateOperId;
    }

    /**
     * 修改人
     * @param updateOperId 修改人
     */
    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }
}