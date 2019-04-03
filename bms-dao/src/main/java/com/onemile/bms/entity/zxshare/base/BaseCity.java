package com.onemile.bms.entity.zxshare.base;

import java.io.Serializable;

public class BaseCity implements Serializable {
    /**
     * 行政区域id
     */
    private Integer id;

    /**
     * 类型，1：省，直辖市，2：地级市，3：区县
     */
    private Integer type;

    /**
     * 所属行政区域
     */
    private Integer parentId;

    /**
     * 行政区域名称
     */
    private String name;

    /**
     * 行政区域id
     * @return id 行政区域id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 行政区域id
     * @param id 行政区域id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 类型，1：省，直辖市，2：地级市，3：区县
     * @return type 类型，1：省，直辖市，2：地级市，3：区县
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型，1：省，直辖市，2：地级市，3：区县
     * @param type 类型，1：省，直辖市，2：地级市，3：区县
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 所属行政区域
     * @return parent_id 所属行政区域
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 所属行政区域
     * @param parentId 所属行政区域
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 行政区域名称
     * @return name 行政区域名称
     */
    public String getName() {
        return name;
    }

    /**
     * 行政区域名称
     * @param name 行政区域名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}