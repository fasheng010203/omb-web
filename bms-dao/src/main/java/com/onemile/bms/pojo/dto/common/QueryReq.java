package com.onemile.bms.pojo.dto.common;


import com.onemile.bms.page.PageReq;

/**
 * Created by Hardy on 2018-09-11.
 */
public class QueryReq extends PageReq {

    /**
     *
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;

    /****使用日期****/
    private String expireBegin;
    private String expireEnd;

    /****发布日期****/
    private String createBegin;
    private String createEnd;

    /****更新日期****/
    private String updateBegin;
    private String updateEnd;

    /**
     * 商品类别id goods_category.id
     */
    private Integer catId;
    /**
     * 商品规格型号 goods_spec.id
     */
    private Integer specId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExpireBegin() {
        return expireBegin;
    }

    public void setExpireBegin(String expireBegin) {
        this.expireBegin = expireBegin;
    }

    public String getExpireEnd() {
        return expireEnd;
    }

    public void setExpireEnd(String expireEnd) {
        this.expireEnd = expireEnd;
    }

    public String getCreateBegin() {
        return createBegin;
    }

    public void setCreateBegin(String createBegin) {
        this.createBegin = createBegin;
    }

    public String getCreateEnd() {
        return createEnd;
    }

    public void setCreateEnd(String createEnd) {
        this.createEnd = createEnd;
    }

    public String getUpdateBegin() {
        return updateBegin;
    }

    public void setUpdateBegin(String updateBegin) {
        this.updateBegin = updateBegin;
    }

    public String getUpdateEnd() {
        return updateEnd;
    }

    public void setUpdateEnd(String updateEnd) {
        this.updateEnd = updateEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

}
