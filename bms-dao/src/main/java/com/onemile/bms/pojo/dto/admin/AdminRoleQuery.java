package com.onemile.bms.pojo.dto.admin;


import com.onemile.bms.page.PageReq;

/**
 * @author Eric
 * @Description:
 * @date 2018/5/23
 */
public class AdminRoleQuery extends PageReq {

    private Long mchId;
    private String roleName;
    private String beginDate;
    private String endDate;

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
