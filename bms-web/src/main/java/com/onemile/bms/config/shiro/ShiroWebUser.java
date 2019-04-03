package com.onemile.bms.config.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * @author Eric
 */
public class ShiroWebUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    private Long id;
    private Long mchId;
    private Integer depId;
    private String loginName;
    private String realName;
    private String mchName;
    private List<Long> roleList;
    private List<Long> permissionList;


    public ShiroWebUser(Long id, Long mchId, Integer depId, String loginName, String realName,String mchName, List<Long> roleList, List<Long> permissionList) {
        this.id = id;
        this.mchId = mchId;
        this.depId = depId;
        this.loginName = loginName;
        this.realName = realName;
        this.mchName = mchName;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }
}
