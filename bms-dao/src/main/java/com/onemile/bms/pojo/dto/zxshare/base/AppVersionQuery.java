package com.onemile.bms.pojo.dto.zxshare.base;

import com.onemile.bms.page.PageReq;

import java.io.Serializable;
import java.util.Date;

public class AppVersionQuery extends PageReq {

    private Integer id;
    private String beginDate;
    private String endDate;
    private String verison;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVerison() {
        return verison;
    }

    public void setVerison(String verison) {
        this.verison = verison;
    }
}