package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.util.Date;

public class UserVerify implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 认证类型  1-企业认证  2-个人认证
     */
    private Integer verifyType;

    /**
     * 真实姓名  个人-身份证姓名  企业-企业名称
     */
    private String realName;

    /**
     * 企业性质
     */
    private String orgType;

    /**
     * 证照编号 身份证，营业执照等
     */
    private String idcardNo;

    /**
     * 身份证正面照
     */
    private String idcardFrontUrl;

    /**
     * 身份证背面照
     */
    private String idcardBackUrl;

    /**
     * 营业执照地址
     */
    private String licenceUrl;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String linkTel;

    /**
     * 0-待审核  1-认证通过   9-不通过
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 
     */
    private Long auditingUserId;

    /**
     * 
     */
    private String auditingUserName;

    /**
     * 
     */
    private Date auditingTime;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 认证类型  1-企业认证  2-个人认证
     * @return verify_type 认证类型  1-企业认证  2-个人认证
     */
    public Integer getVerifyType() {
        return verifyType;
    }

    /**
     * 认证类型  1-企业认证  2-个人认证
     * @param verifyType 认证类型  1-企业认证  2-个人认证
     */
    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
    }

    /**
     * 真实姓名  个人-身份证姓名  企业-企业名称
     * @return real_name 真实姓名  个人-身份证姓名  企业-企业名称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名  个人-身份证姓名  企业-企业名称
     * @param realName 真实姓名  个人-身份证姓名  企业-企业名称
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 企业性质
     * @return org_type 企业性质
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 企业性质
     * @param orgType 企业性质
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * 证照编号 身份证，营业执照等
     * @return idcard_no 证照编号 身份证，营业执照等
     */
    public String getIdcardNo() {
        return idcardNo;
    }

    /**
     * 证照编号 身份证，营业执照等
     * @param idcardNo 证照编号 身份证，营业执照等
     */
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    /**
     * 身份证正面照
     * @return idcard_front_url 身份证正面照
     */
    public String getIdcardFrontUrl() {
        return idcardFrontUrl;
    }

    /**
     * 身份证正面照
     * @param idcardFrontUrl 身份证正面照
     */
    public void setIdcardFrontUrl(String idcardFrontUrl) {
        this.idcardFrontUrl = idcardFrontUrl == null ? null : idcardFrontUrl.trim();
    }

    /**
     * 身份证背面照
     * @return idcard_back_url 身份证背面照
     */
    public String getIdcardBackUrl() {
        return idcardBackUrl;
    }

    /**
     * 身份证背面照
     * @param idcardBackUrl 身份证背面照
     */
    public void setIdcardBackUrl(String idcardBackUrl) {
        this.idcardBackUrl = idcardBackUrl == null ? null : idcardBackUrl.trim();
    }

    /**
     * 营业执照地址
     * @return licence_url 营业执照地址
     */
    public String getLicenceUrl() {
        return licenceUrl;
    }

    /**
     * 营业执照地址
     * @param licenceUrl 营业执照地址
     */
    public void setLicenceUrl(String licenceUrl) {
        this.licenceUrl = licenceUrl == null ? null : licenceUrl.trim();
    }

    /**
     * 省
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 区
     * @return district 区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 区
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 详细地址
     * @return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 联系电话
     * @return link_tel 联系电话
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * 联系电话
     * @param linkTel 联系电话
     */
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    /**
     * 0-待审核  1-认证通过   9-不通过
     * @return status 0-待审核  1-认证通过   9-不通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0-待审核  1-认证通过   9-不通过
     * @param status 0-待审核  1-认证通过   9-不通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * 
     * @return auditing_user_id 
     */
    public Long getAuditingUserId() {
        return auditingUserId;
    }

    /**
     * 
     * @param auditingUserId 
     */
    public void setAuditingUserId(Long auditingUserId) {
        this.auditingUserId = auditingUserId;
    }

    /**
     * 
     * @return auditing_user_name 
     */
    public String getAuditingUserName() {
        return auditingUserName;
    }

    /**
     * 
     * @param auditingUserName 
     */
    public void setAuditingUserName(String auditingUserName) {
        this.auditingUserName = auditingUserName == null ? null : auditingUserName.trim();
    }

    /**
     * 
     * @return auditing_time 
     */
    public Date getAuditingTime() {
        return auditingTime;
    }

    /**
     * 
     * @param auditingTime 
     */
    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }
}