package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserAccountLog implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账户类型  1-可提现账户  2-冻结账户  3-积分账户  4-积分冻结账户
     */
    private Integer accountType;

    /**
     * 交易关联的订单号
     */
    private Long transOrderId;

    /**
     * 交易金额
     */
    private BigDecimal transAmount;

    /**
     * 1-充值 2-销售入账余额 3-提现  4-冻结金额解冻 5-销售金额入账冻结余额  6-提现失败回退 99-其他类型
     */
    private Integer transType;

    /**
     * 交易发生时间
     */
    private Date transTime;

    /**
     * 交易备注信息
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
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
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
     * 账户类型  1-可提现账户  2-冻结账户  3-积分账户  4-积分冻结账户
     * @return account_type 账户类型  1-可提现账户  2-冻结账户  3-积分账户  4-积分冻结账户
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 账户类型  1-可提现账户  2-冻结账户  3-积分账户  4-积分冻结账户
     * @param accountType 账户类型  1-可提现账户  2-冻结账户  3-积分账户  4-积分冻结账户
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 交易关联的订单号
     * @return trans_order_id 交易关联的订单号
     */
    public Long getTransOrderId() {
        return transOrderId;
    }

    /**
     * 交易关联的订单号
     * @param transOrderId 交易关联的订单号
     */
    public void setTransOrderId(Long transOrderId) {
        this.transOrderId = transOrderId;
    }

    /**
     * 交易金额
     * @return trans_amount 交易金额
     */
    public BigDecimal getTransAmount() {
        return transAmount;
    }

    /**
     * 交易金额
     * @param transAmount 交易金额
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * 1-充值 2-销售入账余额 3-提现  4-冻结金额解冻 5-销售金额入账冻结余额  6-提现失败回退 99-其他类型
     * @return trans_type 1-充值 2-销售入账余额 3-提现  4-冻结金额解冻 5-销售金额入账冻结余额  6-提现失败回退 99-其他类型
     */
    public Integer getTransType() {
        return transType;
    }

    /**
     * 1-充值 2-销售入账余额 3-提现  4-冻结金额解冻 5-销售金额入账冻结余额  6-提现失败回退 99-其他类型
     * @param transType 1-充值 2-销售入账余额 3-提现  4-冻结金额解冻 5-销售金额入账冻结余额  6-提现失败回退 99-其他类型
     */
    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    /**
     * 交易发生时间
     * @return trans_time 交易发生时间
     */
    public Date getTransTime() {
        return transTime;
    }

    /**
     * 交易发生时间
     * @param transTime 交易发生时间
     */
    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    /**
     * 交易备注信息
     * @return remark 交易备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 交易备注信息
     * @param remark 交易备注信息
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