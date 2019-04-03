package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

public class AdminDept implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 商户id
     */
    private Long mchId;

    /**
     * 名称
     */
    private String name;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 当前所在层级
     */
    private Integer layer;

    /**
     * 在同一级下的显示顺序
     */
    private Integer orderNo;

    /**
     * 是否是叶子节点（最后一个节点） 1-是 0-否
     */
    private Integer leaf;

    /**
     * 创建时间
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
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商户id
     * @return mch_id 商户id
     */
    public Long getMchId() {
        return mchId;
    }

    /**
     * 商户id
     * @param mchId 商户id
     */
    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父id
     * @return parent_id 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父id
     * @param parentId 父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 当前所在层级
     * @return layer 当前所在层级
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * 当前所在层级
     * @param layer 当前所在层级
     */
    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /**
     * 在同一级下的显示顺序
     * @return order_no 在同一级下的显示顺序
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 在同一级下的显示顺序
     * @param orderNo 在同一级下的显示顺序
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 是否是叶子节点（最后一个节点） 1-是 0-否
     * @return leaf 是否是叶子节点（最后一个节点） 1-是 0-否
     */
    public Integer getLeaf() {
        return leaf;
    }

    /**
     * 是否是叶子节点（最后一个节点） 1-是 0-否
     * @param leaf 是否是叶子节点（最后一个节点） 1-是 0-否
     */
    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
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