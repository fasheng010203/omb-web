package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BillWithDraw implements Serializable {
    /**
     * 提现流水id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 分行名称
     */
    private String bankBranchName;

    /**
     * 账户名称
     */
    private String bankAccountName;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 提现金额
     */
    private BigDecimal amount;

    /**
     * 提现类型 1-快速提现 2-普通提现
     */
    private Integer withDrawType;

    /**
     * 0-提现申请 1-申请成功 2-提现支付中 3-提现成功 4-提现失败
     */
    private Integer status;

    /**
     * 提现支付时间
     */
    private Date payTime;

    /**
     * 打款凭证
     */
    private String payUrl;

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
     * 提现流水id
     * @return id 提现流水id
     */
    public Long getId() {
        return id;
    }

    /**
     * 提现流水id
     * @param id 提现流水id
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
     * 银行编码
     * @return bank_code 银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 银行编码
     * @param bankCode 银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 开户行名称
     * @return bank_name 开户行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 开户行名称
     * @param bankName 开户行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 分行名称
     * @return bank_branch_name 分行名称
     */
    public String getBankBranchName() {
        return bankBranchName;
    }

    /**
     * 分行名称
     * @param bankBranchName 分行名称
     */
    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    /**
     * 账户名称
     * @return bank_account_name 账户名称
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * 账户名称
     * @param bankAccountName 账户名称
     */
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    /**
     * 银行卡号
     * @return bank_card_no 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 银行卡号
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * 提现金额
     * @return amount 提现金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 提现金额
     * @param amount 提现金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 提现类型 1-快速提现 2-普通提现
     * @return with_draw_type 提现类型 1-快速提现 2-普通提现
     */
    public Integer getWithDrawType() {
        return withDrawType;
    }

    /**
     * 提现类型 1-快速提现 2-普通提现
     * @param withDrawType 提现类型 1-快速提现 2-普通提现
     */
    public void setWithDrawType(Integer withDrawType) {
        this.withDrawType = withDrawType;
    }

    /**
     * 0-提现申请 1-申请成功 2-提现支付中 3-提现成功 4-提现失败
     * @return status 0-提现申请 1-申请成功 2-提现支付中 3-提现成功 4-提现失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0-提现申请 1-申请成功 2-提现支付中 3-提现成功 4-提现失败
     * @param status 0-提现申请 1-申请成功 2-提现支付中 3-提现成功 4-提现失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 提现支付时间
     * @return pay_time 提现支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 提现支付时间
     * @param payTime 提现支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 打款凭证
     * @return pay_url 打款凭证
     */
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * 打款凭证
     * @param payUrl 打款凭证
     */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl == null ? null : payUrl.trim();
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