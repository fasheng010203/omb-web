package com.onemile.bms.entity.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eric
 */
public class AdminResource implements Serializable {
    /**
     * ID（手动维护）
     */
    private Long id;

    /**
     * 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     */
    private String code;

    /**
     * 系统标识
     */
    private Long appId;

    /**
     * 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     */
    private Integer type;

    /**
     * 是否是超级菜单(超级管理员可见） 1-是 0-否
     */
    private Integer isSuper;

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
     * 菜单图标样式
     */
    private String icon;

    /**
     * 说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * ID（手动维护）
     * @return id ID（手动维护）
     */
    public Long getId() {
        return id;
    }

    /**
     * ID（手动维护）
     * @param id ID（手动维护）
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     * @return code 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     */
    public String getCode() {
        return code;
    }

    /**
     * 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     * @param code 代码字段（大写字母，下划线，数字组成，不能以数字打头），且只能初始化不能修改；
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 系统标识
     * @return app_id 系统标识
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 系统标识
     * @param appId 系统标识
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     * @return type 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     * @param type 类型（1:菜单；2：操作或按钮 3: 虚拟菜单）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 是否是超级菜单(超级管理员可见） 1-是 0-否
     * @return is_super 是否是超级菜单(超级管理员可见） 1-是 0-否
     */
    public Integer getIsSuper() {
        return isSuper;
    }

    /**
     * 是否是超级菜单(超级管理员可见） 1-是 0-否
     * @param isSuper 是否是超级菜单(超级管理员可见） 1-是 0-否
     */
    public void setIsSuper(Integer isSuper) {
        this.isSuper = isSuper;
    }

    /**
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 是否叶子菜单
     * @return menu_leaf_flag 是否叶子菜单
     */
    public Integer getMenuLeafFlag() {
        return menuLeafFlag;
    }

    /**
     * 是否叶子菜单
     * @param menuLeafFlag 是否叶子菜单
     */
    public void setMenuLeafFlag(Integer menuLeafFlag) {
        this.menuLeafFlag = menuLeafFlag;
    }

    /**
     * 叶子菜单url
     * @return menu_leaf_url 叶子菜单url
     */
    public String getMenuLeafUrl() {
        return menuLeafUrl;
    }

    /**
     * 叶子菜单url
     * @param menuLeafUrl 叶子菜单url
     */
    public void setMenuLeafUrl(String menuLeafUrl) {
        this.menuLeafUrl = menuLeafUrl == null ? null : menuLeafUrl.trim();
    }

    /**
     * 叶子菜单打开方式（1：tab；2：dialogue）
     * @return menu_leaf_mode 叶子菜单打开方式（1：tab；2：dialogue）
     */
    public Integer getMenuLeafMode() {
        return menuLeafMode;
    }

    /**
     * 叶子菜单打开方式（1：tab；2：dialogue）
     * @param menuLeafMode 叶子菜单打开方式（1：tab；2：dialogue）
     */
    public void setMenuLeafMode(Integer menuLeafMode) {
        this.menuLeafMode = menuLeafMode;
    }

    /**
     * 上级ID
     * @return pid 上级ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 上级ID
     * @param pid 上级ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 所在层级
     * @return layer 所在层级
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * 所在层级
     * @param layer 所在层级
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
     * 菜单图标样式
     * @return icon 菜单图标样式
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标样式
     * @param icon 菜单图标样式
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 说明
     * @return remark 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 说明
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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