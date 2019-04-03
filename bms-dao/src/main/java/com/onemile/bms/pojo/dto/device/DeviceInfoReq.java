package com.onemile.bms.pojo.dto.device;

import java.io.Serializable;

/**
 * @author ericma
 */
public class DeviceInfoReq implements Serializable {

    private Long id;
    private String devid;
    private String title;
    private String cmd;
    private String devdesc;
    private String authinfo;
    private String online;
    private String qrurl;
    private String isfix;
    private String islost;
    /**
     * 省份ID
     */
    private String provinceid;
    /**
     * 所属城市Id
     */
    private String cityid;

    /**
     * 是否入库 0：入库  1：出库
     */
    private String isinstock;


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
    public String getDevId() {
        return devid;
    }
    public void setDevId(String devid) { this.devid = devid; }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCmd() {
        return cmd;
    }
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public String getDevdesc() {
        return devdesc;
    }

    public void setDevdesc(String devdesc) {
        this.devdesc = devdesc;
    }

    public String getAuthInfo() {
        return authinfo;
    }
    public void setAuthInfo(String authinfo) {
        this.authinfo = authinfo;
    }
    public String getQrurl() {
        return qrurl;
    }
    public void setQrurl(String qrurl) {
        this.qrurl = qrurl;
    }
    public String getIsfix() {
        return isfix;
    }
    public void setIsfix(String isfix) {
        this.isfix = isfix;
    }
    public String getIslost() {
        return islost;
    }
    public void setIslost(String islost) {
        this.islost = islost;
    }
    /**
     * 是否入库 0：入库  1：出库
     * @return isinstock 是否入库 0：入库  1：出库
     */
    public String getIsinstock() {
        return isinstock;
    }

    /**
     * 是否入库 0：入库  1：出库
     * @param isinstock 是否入库 0：入库  1：出库
     */
    public void setIsinstock(String isinstock) {
        this.isinstock = isinstock == null ? null : isinstock.trim();
    }

    /**
     * 所属城市Id
     * @return cityid 所属城市Id
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 所属城市Id
     * @param cityid 所属城市Id
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    /**
     * 省份ID
     * @return provinceid 省份ID
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * 省份ID
     * @param provinceid 省份ID
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }


    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }
}