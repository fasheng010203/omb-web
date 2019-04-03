package com.onemile.bms.entity.device;

import java.io.Serializable;
import java.util.Date;

public class SbStatus implements Serializable {
    /**
     * ID
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
     * SB 内温度，摄氏度
     */
    private String temp;

    /**
     * SB 内湿度，0-100
     */
    private String humi;

    /**
     * 主电池电压
     */
    private Integer mbat;

    /**
     * 辅助电池电压
     */
    private Integer sbat;

    /**
     * 主电源电压，v
     */
    private String vbat;

    /**
     * 增氧泵 A 状态，”GO”，工作;”STOP”，不工作
     */
    private String obsa;

    /**
     * 增氧泵 B 状态，”GO”，工作;”STOP”，不工作
     */
    private String obsb;

    /**
     * 箱门状态，”OPEN”，打开;”CLOSE”，关闭
     */
    private String gate;

    /**
     * 
     */
    private String at;

    /**
     * 创建时间
     */
    private Date gmtCreate;

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
     * SB 内温度，摄氏度
     * @return temp SB 内温度，摄氏度
     */
    public String getTemp() {
        return temp;
    }

    /**
     * SB 内温度，摄氏度
     * @param temp SB 内温度，摄氏度
     */
    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    /**
     * SB 内湿度，0-100
     * @return humi SB 内湿度，0-100
     */
    public String getHumi() {
        return humi;
    }

    /**
     * SB 内湿度，0-100
     * @param humi SB 内湿度，0-100
     */
    public void setHumi(String humi) {
        this.humi = humi == null ? null : humi.trim();
    }

    /**
     * 主电池电压
     * @return mbat 主电池电压
     */
    public Integer getMbat() {
        return mbat;
    }

    /**
     * 主电池电压
     * @param mbat 主电池电压
     */
    public void setMbat(Integer mbat) {
        this.mbat = mbat;
    }

    /**
     * 辅助电池电压
     * @return sbat 辅助电池电压
     */
    public Integer getSbat() {
        return sbat;
    }

    /**
     * 辅助电池电压
     * @param sbat 辅助电池电压
     */
    public void setSbat(Integer sbat) {
        this.sbat = sbat;
    }

    /**
     * 主电源电压，v
     * @return vbat 主电源电压，v
     */
    public String getVbat() {
        return vbat;
    }

    /**
     * 主电源电压，v
     * @param vbat 主电源电压，v
     */
    public void setVbat(String vbat) {
        this.vbat = vbat == null ? null : vbat.trim();
    }

    /**
     * 增氧泵 A 状态，”GO”，工作;”STOP”，不工作
     * @return obsA 增氧泵 A 状态，”GO”，工作;”STOP”，不工作
     */
    public String getObsa() {
        return obsa;
    }

    /**
     * 增氧泵 A 状态，”GO”，工作;”STOP”，不工作
     * @param obsa 增氧泵 A 状态，”GO”，工作;”STOP”，不工作
     */
    public void setObsa(String obsa) {
        this.obsa = obsa == null ? null : obsa.trim();
    }

    /**
     * 增氧泵 B 状态，”GO”，工作;”STOP”，不工作
     * @return obsB 增氧泵 B 状态，”GO”，工作;”STOP”，不工作
     */
    public String getObsb() {
        return obsb;
    }

    /**
     * 增氧泵 B 状态，”GO”，工作;”STOP”，不工作
     * @param obsb 增氧泵 B 状态，”GO”，工作;”STOP”，不工作
     */
    public void setObsb(String obsb) {
        this.obsb = obsb == null ? null : obsb.trim();
    }

    /**
     * 箱门状态，”OPEN”，打开;”CLOSE”，关闭
     * @return gate 箱门状态，”OPEN”，打开;”CLOSE”，关闭
     */
    public String getGate() {
        return gate;
    }

    /**
     * 箱门状态，”OPEN”，打开;”CLOSE”，关闭
     * @param gate 箱门状态，”OPEN”，打开;”CLOSE”，关闭
     */
    public void setGate(String gate) {
        this.gate = gate == null ? null : gate.trim();
    }

    /**
     * 
     * @return at 
     */
    public String getAt() {
        return at;
    }

    /**
     * 
     * @param at 
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