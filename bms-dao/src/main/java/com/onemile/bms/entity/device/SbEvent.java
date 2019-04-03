package com.onemile.bms.entity.device;

import java.io.Serializable;
import java.util.Date;

public class SbEvent implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String devId;

    /**
     * 设备名称
     */
    private String title;

    /**
     * GateOpen\GateClose
     */
    private String evt;

    /**
     * 事件发生时刻，SB内时钟
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
     * 
     * @return dev_id 
     */
    public String getDevId() {
        return devId;
    }

    /**
     * 
     * @param devId 
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
     * GateOpen\GateClose
     * @return evt GateOpen\GateClose
     */
    public String getEvt() {
        return evt;
    }

    /**
     * GateOpen\GateClose
     * @param evt GateOpen\GateClose
     */
    public void setEvt(String evt) {
        this.evt = evt == null ? null : evt.trim();
    }

    /**
     * 事件发生时刻，SB内时钟
     * @return at 事件发生时刻，SB内时钟
     */
    public String getAt() {
        return at;
    }

    /**
     * 事件发生时刻，SB内时钟
     * @param at 事件发生时刻，SB内时钟
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