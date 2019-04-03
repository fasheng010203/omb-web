package com.onemile.bms.pojo.vo.admin;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/20
 */
public class AdminUserRoleVO {
    private Long userId;
    private Long roleId;
    private String roleName;
    private Integer checked;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

}
