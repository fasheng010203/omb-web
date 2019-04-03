package com.onemile.bms.entity.zxshare.company;

import java.io.Serializable;
import java.util.Date;

public class UserRank implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Integer rankName;

    /**
     * 
     */
    private Integer minPoints;

    /**
     * 
     */
    private Integer maxPoints;

    /**
     * 
     */
    private Date gmtCreate;

    /**
     * 
     */
    private Date gmtModified;

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
     * @return rank_name 
     */
    public Integer getRankName() {
        return rankName;
    }

    /**
     * 
     * @param rankName 
     */
    public void setRankName(Integer rankName) {
        this.rankName = rankName;
    }

    /**
     * 
     * @return min_points 
     */
    public Integer getMinPoints() {
        return minPoints;
    }

    /**
     * 
     * @param minPoints 
     */
    public void setMinPoints(Integer minPoints) {
        this.minPoints = minPoints;
    }

    /**
     * 
     * @return max_points 
     */
    public Integer getMaxPoints() {
        return maxPoints;
    }

    /**
     * 
     * @param maxPoints 
     */
    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
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

    /**
     * 
     * @return gmt_modified 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 
     * @param gmtModified 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}