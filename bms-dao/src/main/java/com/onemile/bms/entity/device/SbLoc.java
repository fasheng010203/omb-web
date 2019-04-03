package com.onemile.bms.entity.device;

import java.io.Serializable;
import java.util.Date;

public class SbLoc implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 设备ID
     */
    private String devId;

    /**
     * 设备名称
     */
    private String title;

    /**
     * 经度
     */
    private String lat;

    /**
     * 纬度
     */
    private String lon;

    /**
     * 事件发生时刻
     */
    private String at;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设备ID
     * @return dev_id 设备ID
     */
    public String getDevId() {
        return devId;
    }

    /**
     * 设备ID
     * @param devId 设备ID
     */
    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    /**
     * 设备名称
     * @return title 设备名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设备名称
     * @param title 设备名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 经度
     * @return lat 经度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 经度
     * @param lat 经度
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 纬度
     * @return lon 纬度
     */
    public String getLon() {
        return lon;
    }

    /**
     * 纬度
     * @param lon 纬度
     */
    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    /**
     * 事件发生时刻
     * @return at 事件发生时刻
     */
    public String getAt() {
        return at;
    }

    /**
     * 事件发生时刻
     * @param at 事件发生时刻
     */
    public void setAt(String at) {
        this.at = at == null ? null : at.trim();
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
}