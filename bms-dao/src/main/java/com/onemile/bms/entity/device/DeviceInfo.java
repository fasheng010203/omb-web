package com.onemile.bms.entity.device;

import java.io.Serializable;
import java.util.Date;

public class DeviceInfo implements Serializable {
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
     * 二维码图片Url
     */
    private String qrurl;

    /**
     * 设备状态  0-在线  1-离线 
     */
    private String status;

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
     * 省份ID
     */
    private String provinceid;

    /**
     * 所属城市Id
     */
    private String cityid;

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
     * 设备状态  0-在线  1-离线 
     * @return status 设备状态  0-在线  1-离线 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设备状态  0-在线  1-离线 
     * @param status 设备状态  0-在线  1-离线 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}