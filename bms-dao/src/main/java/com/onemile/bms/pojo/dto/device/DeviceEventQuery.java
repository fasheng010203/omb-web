package com.onemile.bms.pojo.dto.device;

import com.onemile.bms.page.PageReq;


public class DeviceEventQuery extends PageReq {

    private String devid;
    private String beginDate;
    private String endDate;
    private String title;
    public String getDevid() {
        return devid;
    }
    public void setDevid(String devid) { this.devid = devid; }
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}