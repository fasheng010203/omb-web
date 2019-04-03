package com.onemile.bms.pojo.dto.admin;

import java.util.Date;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/3
 */
public class AdminCityReq {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userid;

    /**
     * 用户管理城市
     */
    private String usercity;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户ID
     * @return userid 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 用户ID
     * @param userid 用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 用户管理城市
     * @return usercity 用户管理城市
     */
    public String getUsercity() {
        return usercity;
    }

    /**
     * 用户管理城市
     * @param usercity 用户管理城市
     */
    public void setUsercity(String usercity) {
        this.usercity = usercity == null ? null : usercity.trim();
    }

}
