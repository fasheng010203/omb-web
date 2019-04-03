package com.onemile.bms.pojo.dto.admin;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/20
 */
public class AdminUserRoleReq {
    private Long userId;
    private String roleIds;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}
