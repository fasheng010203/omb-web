package com.onemile.bms.pojo.vo.zxshare.operate;

import java.io.Serializable;
import java.util.Date;

public class BannerVO implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 适用场景 1-首页 
     */
    private Integer scene;

    /**
     * 图片的七牛URL
     */
    private String picUrl;

    /**
     * 图片指向的外部链接
     */
    private String linkUrl;

    /**
     * 轮播位置
     */
    private Integer sortNo;

    /**
     * 状态  0-待上线  1-已上线  2-已下线
     */
    private Integer status;

    /**
     * 有效期开始
     */
    private Date effectDate;

    /**
     * 有效期结束
     */
    private Date expireDate;

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
     * 图片名称
     * @return name 图片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 图片名称
     * @param name 图片名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 适用场景 1-首页 
     * @return scene 适用场景 1-首页 
     */
    public Integer getScene() {
        return scene;
    }

    /**
     * 适用场景 1-首页 
     * @param scene 适用场景 1-首页 
     */
    public void setScene(Integer scene) {
        this.scene = scene;
    }

    /**
     * 图片的七牛URL
     * @return pic_url 图片的七牛URL
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 图片的七牛URL
     * @param picUrl 图片的七牛URL
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 图片指向的外部链接
     * @return link_url 图片指向的外部链接
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 图片指向的外部链接
     * @param linkUrl 图片指向的外部链接
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * 轮播位置
     * @return sort_no 轮播位置
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 轮播位置
     * @param sortNo 轮播位置
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 状态  0-待上线  1-已上线  2-已下线
     * @return status 状态  0-待上线  1-已上线  2-已下线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  0-待上线  1-已上线  2-已下线
     * @param status 状态  0-待上线  1-已上线  2-已下线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 有效期开始
     * @return effect_date 有效期开始
     */
    public Date getEffectDate() {
        return effectDate;
    }

    /**
     * 有效期开始
     * @param effectDate 有效期开始
     */
    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    /**
     * 有效期结束
     * @return expire_date 有效期结束
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * 有效期结束
     * @param expireDate 有效期结束
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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