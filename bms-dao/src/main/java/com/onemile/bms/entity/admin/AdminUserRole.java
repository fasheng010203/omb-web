package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

public class AdminUserRole implements Serializable {
    /**
     * 用户与权限关联ID(自增)
     */
    private Long id;

    /**
     * 用户id admin_user.id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 用户与权限关联ID(自增)
     * @return id 用户与权限关联ID(自增)
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户与权限关联ID(自增)
     * @param id 用户与权限关联ID(自增)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id admin_user.id
     * @return user_id 用户id admin_user.id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id admin_user.id
     * @param userId 用户id admin_user.id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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