package com.onemile.bms.pojo.vo.zxshare.order;


import java.util.Date;

/**
 * @author Eric
 * @date 2018/8/27
 */
public class OrderAppraiseBuyerVO {

    private Long appraiseId;
    private String buyer;
    private String buyerHeadUrl;
    private String seller;
    private String sellerHeadUrl;
    private String orderNo;
    private String orderDescribe;
    private Integer description;
    private Integer sendSpeed;
    private Integer sellerService;
    private String appraiseContent;
    private Date createTime;

    public Long getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(Long appraiseId) {
        this.appraiseId = appraiseId;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyerHeadUrl() {
        return buyerHeadUrl;
    }

    public void setBuyerHeadUrl(String buyerHeadUrl) {
        this.buyerHeadUrl = buyerHeadUrl;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellerHeadUrl() {
        return sellerHeadUrl;
    }

    public void setSellerHeadUrl(String sellerHeadUrl) {
        this.sellerHeadUrl = sellerHeadUrl;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Integer getSendSpeed() {
        return sendSpeed;
    }

    public void setSendSpeed(Integer sendSpeed) {
        this.sendSpeed = sendSpeed;
    }

    public Integer getSellerService() {
        return sellerService;
    }

    public void setSellerService(Integer sellerService) {
        this.sellerService = sellerService;
    }

    public String getAppraiseContent() {
        return appraiseContent;
    }

    public void setAppraiseContent(String appraiseContent) {
        this.appraiseContent = appraiseContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderAppraiseBuyerVO{" +
                "appraiseId=" + appraiseId +
                ", buyer='" + buyer + '\'' +
                ", buyerHeadUrl='" + buyerHeadUrl + '\'' +
                ", seller='" + seller + '\'' +
                ", sellerHeadUrl='" + sellerHeadUrl + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderDescribe='" + orderDescribe + '\'' +
                ", description=" + description +
                ", sendSpeed=" + sendSpeed +
                ", sellerService=" + sellerService +
                ", appraiseContent='" + appraiseContent + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
