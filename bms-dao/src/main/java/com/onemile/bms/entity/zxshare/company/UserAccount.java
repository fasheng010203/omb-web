package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserAccount implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账户余额
     */
    private BigDecimal totalAmt;

    /**
     * 冻结余额 (不可提现)
     */
    private BigDecimal frozenAmt;

    /**
     * 用户积分
     */
    private Integer totalPoints;

    /**
     * 冻结积分
     */
    private Integer frozenPoints;

    /**
     * 状态 1-正常 
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

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
     * 账户余额
     * @return total_amt 账户余额
     */
    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    /**
     * 账户余额
     * @param totalAmt 账户余额
     */
    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    /**
     * 冻结余额 (不可提现)
     * @return frozen_amt 冻结余额 (不可提现)
     */
    public BigDecimal getFrozenAmt() {
        return frozenAmt;
    }

    /**
     * 冻结余额 (不可提现)
     * @param frozenAmt 冻结余额 (不可提现)
     */
    public void setFrozenAmt(BigDecimal frozenAmt) {
        this.frozenAmt = frozenAmt;
    }

    /**
     * 用户积分
     * @return total_points 用户积分
     */
    public Integer getTotalPoints() {
        return totalPoints;
    }

    /**
     * 用户积分
     * @param totalPoints 用户积分
     */
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * 冻结积分
     * @return frozen_points 冻结积分
     */
    public Integer getFrozenPoints() {
        return frozenPoints;
    }

    /**
     * 冻结积分
     * @param frozenPoints 冻结积分
     */
    public void setFrozenPoints(Integer frozenPoints) {
        this.frozenPoints = frozenPoints;
    }

    /**
     * 状态 1-正常 
     * @return status 状态 1-正常 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 1-正常 
     * @param status 状态 1-正常 
     */
    public void setStatus(Integer status) {
        this.status = status;
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