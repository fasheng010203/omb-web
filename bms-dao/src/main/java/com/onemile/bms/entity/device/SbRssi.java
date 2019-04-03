package com.onemile.bms.entity.device;

import java.io.Serializable;
import java.util.Date;

public class SbRssi implements Serializable {
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
     * 4G 网络的信号强度
     */
    private String rssi;

    /**
     * 事件发生时刻
     */
    private String at;

    /**
     * 
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
     * 4G 网络的信号强度
     * @return rssi 4G 网络的信号强度
     */
    public String getRssi() {
        return rssi;
    }

    /**
     * 4G 网络的信号强度
     * @param rssi 4G 网络的信号强度
     */
    public void setRssi(String rssi) {
        this.rssi = rssi == null ? null : rssi.trim();
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
     * 
     * @return gmt_create 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 
     * @param gmtCreate 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}