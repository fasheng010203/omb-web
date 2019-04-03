package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

public class AdminRoleResource implements Serializable {
    /**
     * 角色与资源关联id（自增）
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 2：资源；3：系统
     */
    private Integer type;

    /**
     * 资源id
     */
    private Long resourceId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 角色与资源关联id（自增）
     * @return id 角色与资源关联id（自增）
     */
    public Long getId() {
        return id;
    }

    /**
     * 角色与资源关联id（自增）
     * @param id 角色与资源关联id（自增）
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色ID
     * @return role_id 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 2：资源；3：系统
     * @return type 2：资源；3：系统
     */
    public Integer getType() {
        return type;
    }

    /**
     * 2：资源；3：系统
     * @param type 2：资源；3：系统
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 资源id
     * @return resource_id 资源id
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 资源id
     * @param resourceId 资源id
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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