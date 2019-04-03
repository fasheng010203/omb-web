package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

public class AdminRole implements Serializable {
    /**
     * 角色ID（手动维护）
     */
    private Long id;

    /**
     * 商户id
     */
    private Long mchId;

    /**
     * 角色编号（大写字母，下划线，数字组成，不能以数字打头），不能修改
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 关联用户数
     */
    private Integer userCnt;

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
     * 角色ID（手动维护）
     * @return id 角色ID（手动维护）
     */
    public Long getId() {
        return id;
    }

    /**
     * 角色ID（手动维护）
     * @param id 角色ID（手动维护）
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商户id
     * @return mch_id 商户id
     */
    public Long getMchId() {
        return mchId;
    }

    /**
     * 商户id
     * @param mchId 商户id
     */
    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    /**
     * 角色编号（大写字母，下划线，数字组成，不能以数字打头），不能修改
     * @return code 角色编号（大写字母，下划线，数字组成，不能以数字打头），不能修改
     */
    public String getCode() {
        return code;
    }

    /**
     * 角色编号（大写字母，下划线，数字组成，不能以数字打头），不能修改
     * @param code 角色编号（大写字母，下划线，数字组成，不能以数字打头），不能修改
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 关联用户数
     * @return user_cnt 关联用户数
     */
    public Integer getUserCnt() {
        return userCnt;
    }

    /**
     * 关联用户数
     * @param userCnt 关联用户数
     */
    public void setUserCnt(Integer userCnt) {
        this.userCnt = userCnt;
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
}