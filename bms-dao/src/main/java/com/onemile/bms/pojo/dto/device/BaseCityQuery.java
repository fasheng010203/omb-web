package com.onemile.bms.pojo.dto.device;

import com.onemile.bms.pojo.dto.common.QueryReq;


public class BaseCityQuery extends QueryReq {


    /**
     * 所属类目
     */
    private Integer parentId;

//    /**
//     * 用户ID
//     */
//    private String userId;

    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

//    public String getNewUserId() {
//        return userId;
//    }
//    public void setNewUserId(String userId) {
//        this.userId = userId;
//    }
}