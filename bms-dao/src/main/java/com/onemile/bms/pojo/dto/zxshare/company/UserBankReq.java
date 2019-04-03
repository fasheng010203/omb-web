package com.onemile.bms.pojo.dto.zxshare.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserBankReq implements Serializable {
    /**
     * 自增主键
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
     * 开户银行支行名称
     */
    private String bankBarchName;

    /**
     * 开户名
     */
    private String bankAccountName;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行卡类型   DC: "储蓄卡",CC: "信用卡", SCC: "准贷记卡", PC: "预付费卡"
     */
    private String cardType;

    /**
     * 认证银行卡的打款金额
     */
    private BigDecimal payAmout;

    /**
     * 系统打款时间
     */
    private String payTime;

    /**
     * 
     */
    private String payUrl;

    /**
     * 认证时间
     */
    private Date verifyTime;

    /**
     * 是否是默认提现银行卡
     */
    private Integer isDefault;

    /**
     * 0-未认证 1-已认证 2-不通过
     */
    private Integer status;

    /**
     * 认证的操作员id
     */
    private Long verifyOperatorId;

    /**
     * 认证的操作员名称
     */
    private String verifyOperatorName;

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
     * 开户银行支行名称
     * @return bank_barch_name 开户银行支行名称
     */
    public String getBankBarchName() {
        return bankBarchName;
    }

    /**
     * 开户银行支行名称
     * @param bankBarchName 开户银行支行名称
     */
    public void setBankBarchName(String bankBarchName) {
        this.bankBarchName = bankBarchName == null ? null : bankBarchName.trim();
    }

    /**
     * 开户名
     * @return bank_account_name 开户名
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * 开户名
     * @param bankAccountName 开户名
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
     * 银行卡类型   DC: "储蓄卡",CC: "信用卡", SCC: "准贷记卡", PC: "预付费卡"
     * @return card_type 银行卡类型   DC: "储蓄卡",CC: "信用卡", SCC: "准贷记卡", PC: "预付费卡"
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 银行卡类型   DC: "储蓄卡",CC: "信用卡", SCC: "准贷记卡", PC: "预付费卡"
     * @param cardType 银行卡类型   DC: "储蓄卡",CC: "信用卡", SCC: "准贷记卡", PC: "预付费卡"
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 认证银行卡的打款金额
     * @return pay_amout 认证银行卡的打款金额
     */
    public BigDecimal getPayAmout() {
        return payAmout;
    }

    /**
     * 认证银行卡的打款金额
     * @param payAmout 认证银行卡的打款金额
     */
    public void setPayAmout(BigDecimal payAmout) {
        this.payAmout = payAmout;
    }

    /**
     * 系统打款时间
     * @return pay_time 系统打款时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 系统打款时间
     * @param payTime 系统打款时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 
     * @return pay_url 
     */
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * 
     * @param payUrl 
     */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl == null ? null : payUrl.trim();
    }

    /**
     * 认证时间
     * @return verify_time 认证时间
     */
    public Date getVerifyTime() {
        return verifyTime;
    }

    /**
     * 认证时间
     * @param verifyTime 认证时间
     */
    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    /**
     * 是否是默认提现银行卡
     * @return is_default 是否是默认提现银行卡
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 是否是默认提现银行卡
     * @param isDefault 是否是默认提现银行卡
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 0-未认证 1-已认证 2-不通过
     * @return status 0-未认证 1-已认证 2-不通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0-未认证 1-已认证 2-不通过
     * @param status 0-未认证 1-已认证 2-不通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 认证的操作员id
     * @return verify_operator_id 认证的操作员id
     */
    public Long getVerifyOperatorId() {
        return verifyOperatorId;
    }

    /**
     * 认证的操作员id
     * @param verifyOperatorId 认证的操作员id
     */
    public void setVerifyOperatorId(Long verifyOperatorId) {
        this.verifyOperatorId = verifyOperatorId;
    }

    /**
     * 认证的操作员名称
     * @return verify_operator_name 认证的操作员名称
     */
    public String getVerifyOperatorName() {
        return verifyOperatorName;
    }

    /**
     * 认证的操作员名称
     * @param verifyOperatorName 认证的操作员名称
     */
    public void setVerifyOperatorName(String verifyOperatorName) {
        this.verifyOperatorName = verifyOperatorName == null ? null : verifyOperatorName.trim();
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

    public Long getAuditingUserId() {
        return auditingUserId;
    }

    public void setAuditingUserId(Long auditingUserId) {
        this.auditingUserId = auditingUserId;
    }

    public String getAuditingUserName() {
        return auditingUserName;
    }

    public void setAuditingUserName(String auditingUserName) {
        this.auditingUserName = auditingUserName;
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }
}