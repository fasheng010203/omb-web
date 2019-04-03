package com.onemile.bms.config;

import java.io.Serializable;
import java.util.List;

/**
 * @author Eric
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    private Long id;
    private String name;
    private String realName;
    private List<Long> roleList;
    private List<Long> permissionList;


    public ShiroUser(Long id, String name, String realName, List<Long> roleList, List<Long> permissionList) {
        this.id = id;
        this.name = name;
        this.realName = realName;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<Long> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Long> roleList) {
        this.roleList = roleList;
    }

    public List<Long> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Long> permissionList) {
        this.permissionList = permissionList;
    }


}
