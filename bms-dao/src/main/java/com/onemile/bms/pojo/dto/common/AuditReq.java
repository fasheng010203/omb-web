package com.onemile.bms.pojo.dto.common;

public class AuditReq extends DeleteReq{

    private Integer status;
    private Long auditingUserId;
    private String auditingUserName;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}