package com.onemile.bms.pojo.dto.zxshare.operate;

import com.onemile.bms.page.PageReq;

public class BannerQuery extends PageReq {
    private Long id;
    private String name;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
