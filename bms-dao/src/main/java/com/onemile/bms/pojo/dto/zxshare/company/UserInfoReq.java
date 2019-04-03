package com.onemile.bms.pojo.dto.zxshare.company;

import java.io.Serializable;
import java.util.Date;

public class UserInfoReq implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户登录名称
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 交易密码
     */
    private String payPassword;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 头像
     */
    private String headUrl;

    /**
     * 用户等级信誉积分
     */
    private Integer rankPoints;

    /**
     * 状态位   1-正常   9-冻结
     */
    private Integer status;

    /**
     * 最后登录的经度
     */
    private String lastX;

    /**
     * 最后登录的纬度
     */
    private String lastY;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;


    private String verifyTypeName;

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
     * 用户登录名称
     * @return user_name 用户登录名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户登录名称
     * @param userName 用户登录名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 登录密码
     * @return password 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 交易密码
     * @return pay_password 交易密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 交易密码
     * @param payPassword 交易密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    /**
     * 昵称
     * @return nick_name 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 性别
     * @return gender 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 头像
     * @return head_url 头像
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     * 头像
     * @param headUrl 头像
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    /**
     * 用户等级信誉积分
     * @return rank_points 用户等级信誉积分
     */
    public Integer getRankPoints() {
        return rankPoints;
    }

    /**
     * 用户等级信誉积分
     * @param rankPoints 用户等级信誉积分
     */
    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    /**
     * 状态位   1-正常   9-冻结
     * @return status 状态位   1-正常   9-冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态位   1-正常   9-冻结
     * @param status 状态位   1-正常   9-冻结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 最后登录的经度
     * @return last_x 最后登录的经度
     */
    public String getLastX() {
        return lastX;
    }

    /**
     * 最后登录的经度
     * @param lastX 最后登录的经度
     */
    public void setLastX(String lastX) {
        this.lastX = lastX == null ? null : lastX.trim();
    }

    /**
     * 最后登录的纬度
     * @return last_y 最后登录的纬度
     */
    public String getLastY() {
        return lastY;
    }

    /**
     * 最后登录的纬度
     * @param lastY 最后登录的纬度
     */
    public void setLastY(String lastY) {
        this.lastY = lastY == null ? null : lastY.trim();
    }

    /**
     * 最后登录IP
     * @return last_login_ip 最后登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登录IP
     * @param lastLoginIp 最后登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * 最后登录时间
     * @return last_login_time 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

    public String getVerifyTypeName() {
        return verifyTypeName;
    }

    public void setVerifyTypeName(String verifyTypeName) {
        this.verifyTypeName = verifyTypeName;
    }
}