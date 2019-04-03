package com.onemile.bms.pojo.dto.device;

import java.io.Serializable;
import java.util.Date;

public class DeviceInfoDTO implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 设备名称
     */
    private String title;

    /**
     * 设备在线状态，true为在线，false为离线
     */
    private String online;

    /**
     * 设备描述
     */
    private String devdesc;

    /**
     * 设备标签
     */
    private String tags;

    /**
     * 接入协议
     */
    private String protocol;

    /**
     * {"lon":106, "lat": 29, "ele": 370},//设备位置{"经度", "纬度", "高度"}（可选）
     */
    private String location;

    /**
     * HTTP设备："设备唯一编号"（可选）
     */
    private String authInfo;

    /**
     *  true| false, //设备私密性（可选）
     */
    private String sbprivate;

    /**
     * 设备创建时间
     */
    private Date createTime;

    /**
     * 设备编号
     */
    private String devId;

    /**
     * 设备状态  0-在线  1-离线
     */
    private Integer status;

    /**
     * 创建操作员id
     */
    private Long createOperId;

    /**
     * 创建人
     */
    private String createOperName;

    /**
     * 更新操作员id
     */
    private Long updateOperId;

    /**
     * 更新人
     */
    private String updateOperName;

    /**
     * 更新时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 省份ID
     */
    private String provinceid;


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
     *
     */
    private String batcnt;

    /**
     * 二维码图片Url
     */
    private String qrurl;


    /**
     * 是否待维修 0：待维修 1：已维修
     */
    private String isfix;

    /**
     * 是否丢失 0：未丢失 1：丢失
     */
    private String islost;


    /**
     * 是否入库 0：入库  1：出库
     */
    private String isinstock;



    /**
     * 事件
     */
    private String evt;



    /**
     * 经度
     */
    private String lat;

    /**
     * 纬度
     */
    private String lon;


    /**
     * 设备所属城市
     */
    private String cityid;



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
     * 设备在线状态，true为在线，false为离线
     * @return online 设备在线状态，true为在线，false为离线
     */
    public String getOnline() {
        return online;
    }

    /**
     * 设备在线状态，true为在线，false为离线
     * @param online 设备在线状态，true为在线，false为离线
     */
    public void setOnline(String online) {
        this.online = online == null ? null : online.trim();
    }

    /**
     * 设备描述
     * @return devdesc 设备描述
     */
    public String getDevdesc() {
        return devdesc;
    }

    /**
     * 设备描述
     * @param devdesc 设备描述
     */
    public void setDevdesc(String devdesc) {
        this.devdesc = devdesc == null ? null : devdesc.trim();
    }

    /**
     * 设备标签
     * @return tags 设备标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设备标签
     * @param tags 设备标签
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * 接入协议
     * @return protocol 接入协议
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * 接入协议
     * @param protocol 接入协议
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    /**
     * {"lon":106, "lat": 29, "ele": 370},//设备位置{"经度", "纬度", "高度"}（可选）
     * @return location {"lon":106, "lat": 29, "ele": 370},//设备位置{"经度", "纬度", "高度"}（可选）
     */
    public String getLocation() {
        return location;
    }

    /**
     * {"lon":106, "lat": 29, "ele": 370},//设备位置{"经度", "纬度", "高度"}（可选）
     * @param location {"lon":106, "lat": 29, "ele": 370},//设备位置{"经度", "纬度", "高度"}（可选）
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * HTTP设备："设备唯一编号"（可选）
     * @return auth_info HTTP设备："设备唯一编号"（可选）
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * HTTP设备："设备唯一编号"（可选）
     * @param authInfo HTTP设备："设备唯一编号"（可选）
     */
    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo == null ? null : authInfo.trim();
    }

    /**
     *  true| false, //设备私密性（可选）
     * @return sbprivate  true| false, //设备私密性（可选）
     */
    public String getSbprivate() {
        return sbprivate;
    }

    /**
     *  true| false, //设备私密性（可选）
     * @param sbprivate  true| false, //设备私密性（可选）
     */
    public void setSbprivate(String sbprivate) {
        this.sbprivate = sbprivate == null ? null : sbprivate.trim();
    }

    /**
     * 设备创建时间
     * @return create_time 设备创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设备创建时间
     * @param createTime 设备创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设备编号
     * @return dev_id 设备编号
     */
    public String getDevId() {
        return devId;
    }

    /**
     * 设备编号
     * @param devId 设备编号
     */
    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    /**
     * 设备状态  0-在线  1-离线
     * @return status 设备状态  0-在线  1-离线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设备状态  0-在线  1-离线
     * @param status 设备状态  0-在线  1-离线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建操作员id
     * @return create_oper_id 创建操作员id
     */
    public Long getCreateOperId() {
        return createOperId;
    }

    /**
     * 创建操作员id
     * @param createOperId 创建操作员id
     */
    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    /**
     * 创建人
     * @return create_oper_name 创建人
     */
    public String getCreateOperName() {
        return createOperName;
    }

    /**
     * 创建人
     * @param createOperName 创建人
     */
    public void setCreateOperName(String createOperName) {
        this.createOperName = createOperName == null ? null : createOperName.trim();
    }

    /**
     * 更新操作员id
     * @return update_oper_id 更新操作员id
     */
    public Long getUpdateOperId() {
        return updateOperId;
    }

    /**
     * 更新操作员id
     * @param updateOperId 更新操作员id
     */
    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

    /**
     * 更新人
     * @return update_oper_name 更新人
     */
    public String getUpdateOperName() {
        return updateOperName;
    }

    /**
     * 更新人
     * @param updateOperName 更新人
     */
    public void setUpdateOperName(String updateOperName) {
        this.updateOperName = updateOperName == null ? null : updateOperName.trim();
    }

    /**
     * 更新时间
     * @return gmt_create 更新时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 更新时间
     * @param gmtCreate 更新时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
     *
     * @return batcnt
     */
    public String getBatcnt() {
        return batcnt;
    }

    /**
     *
     * @param batcnt
     */
    public void setBatcnt(String batcnt) {
        this.batcnt = batcnt == null ? null : batcnt.trim();
    }



    /**
     * 二维码图片Url
     * @return qrurl 二维码图片Url
     */
    public String getQrurl() {
        return qrurl;
    }

    /**
     * 二维码图片Url
     * @param qrurl 二维码图片Url
     */
    public void setQrurl(String qrurl) {
        this.qrurl = qrurl == null ? null : qrurl.trim();
    }

    /**
     * 是否待维修 0：待维修 1：已维修
     * @return isfix 是否待维修 0：待维修 1：已维修
     */
    public String getIsfix() {
        return isfix;
    }

    /**
     * 是否待维修 0：待维修 1：已维修
     * @param isfix 是否待维修 0：待维修 1：已维修
     */
    public void setIsfix(String isfix) {
        this.isfix = isfix == null ? null : isfix.trim();
    }

    /**
     * 是否丢失 0：未丢失 1：丢失
     * @return islost 是否丢失 0：未丢失 1：丢失
     */
    public String getIslost() {
        return islost;
    }

    /**
     * 是否丢失 0：未丢失 1：丢失
     * @param islost 是否丢失 0：未丢失 1：丢失
     */
    public void setIslost(String islost) {
        this.islost = islost == null ? null : islost.trim();
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
     *
     * @return evt
     */
    public String getEvt() {
        return evt;
    }

    /**
     *
     * @param evt
     */
    public void setEvt(String evt) {
        this.evt = evt == null ? null : evt.trim();
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



}