package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eric
 */
public class AdminUser implements Serializable {
    /**
     * 用户的自增id号
     */
    private Long id;

    /**
     * 所属商户id
     */
    private Long mchId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 0为禁用，1为启用
     */
    private Integer status;

    /**
     * 是否删除  0-否 1-是
     */
    private Integer isDelete;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * email
     */
    private String email;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 操作员编码
     */
    private String operCode;

    /**
     * 性别：1：男，0：女
     */
    private String sex;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 用户的自增id号
     *
     * @return id 用户的自增id号
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户的自增id号
     *
     * @param id 用户的自增id号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 所属商户id
     *
     * @return mch_id 所属商户id
     */
    public Long getMchId() {
        return mchId;
    }

    /**
     * 所属商户id
     *
     * @param mchId 所属商户id
     */
    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    /**
     * 登录名
     *
     * @return login_name 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 登录密码
     *
     * @return login_pwd 登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 登录密码
     *
     * @param loginPwd 登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * 真实姓名
     *
     * @return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 0为禁用，1为启用
     *
     * @return status 0为禁用，1为启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0为禁用，1为启用
     *
     * @param status 0为禁用，1为启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否删除  0-否 1-是
     *
     * @return is_delete 是否删除  0-否 1-是
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除  0-否 1-是
     *
     * @param isDelete 是否删除  0-否 1-是
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 手机号
     *
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * email
     *
     * @return email email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 部门id
     *
     * @return dept_id 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 操作员编码
     *
     * @return oper_code 操作员编码
     */
    public String getOperCode() {
        return operCode;
    }

    /**
     * 操作员编码
     *
     * @param operCode 操作员编码
     */
    public void setOperCode(String operCode) {
        this.operCode = operCode == null ? null : operCode.trim();
    }

    /**
     * 性别：1：男，0：女
     *
     * @return sex 性别：1：男，0：女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别：1：男，0：女
     *
     * @param sex 性别：1：男，0：女
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 联系地址
     *
     * @return address 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 创建时间
     *
     * @return gmt_create 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     *
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}