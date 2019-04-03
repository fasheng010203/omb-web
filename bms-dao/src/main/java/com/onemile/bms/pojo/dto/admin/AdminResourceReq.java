package com.onemile.bms.pojo.dto.admin;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/19
 */
public class AdminResourceReq {
    /**
     * ID（手动维护）
     */
    private Long id;

    /**
     * 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     */
    private String code;

    /**
     * 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     */
    private Integer type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 是否叶子菜单
     */
    private Integer menuLeafFlag;

    /**
     * 叶子菜单url
     */
    private String menuLeafUrl;

    /**
     * 叶子菜单打开方式（1：tab；2：dialogue）
     */
    private Integer menuLeafMode;

    /**
     * 上级ID
     */
    private Long pid;

    /**
     * 所在层级
     */
    private Integer layer;

    /**
     * 在同一级下的显示顺序
     */
    private Integer orderNo;

    /**
     * 说明
     */
    private String remark;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否是超级菜单
     */
    private Integer isSuper;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuLeafFlag() {
        return menuLeafFlag;
    }

    public void setMenuLeafFlag(Integer menuLeafFlag) {
        this.menuLeafFlag = menuLeafFlag;
    }

    public String getMenuLeafUrl() {
        return menuLeafUrl;
    }

    public void setMenuLeafUrl(String menuLeafUrl) {
        this.menuLeafUrl = menuLeafUrl;
    }

    public Integer getMenuLeafMode() {
        return menuLeafMode;
    }

    public void setMenuLeafMode(Integer menuLeafMode) {
        this.menuLeafMode = menuLeafMode;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Integer isSuper) {
        this.isSuper = isSuper;
    }
}
