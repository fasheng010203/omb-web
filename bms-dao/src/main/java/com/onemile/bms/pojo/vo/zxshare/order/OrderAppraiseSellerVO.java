package com.onemile.bms.pojo.vo.zxshare.order;


import java.util.Date;

/**
 * @author Eric
 * @date 2018/8/27
 */
public class OrderAppraiseSellerVO {

    private Long appraiseId;
    private String buyer;
    private String buyerHeadUrl;
    private String seller;
    private String sellerHeadUrl;
    private String orderNo;
    private String orderDescribe;
    private Integer paySpeed;
    private Integer receiveSpeed;
    private Integer buyerService;
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

    public Integer getPaySpeed() {
        return paySpeed;
    }

    public void setPaySpeed(Integer paySpeed) {
        this.paySpeed = paySpeed;
    }

    public Integer getReceiveSpeed() {
        return receiveSpeed;
    }

    public void setReceiveSpeed(Integer receiveSpeed) {
        this.receiveSpeed = receiveSpeed;
    }

    public Integer getBuyerService() {
        return buyerService;
    }

    public void setBuyerService(Integer buyerService) {
        this.buyerService = buyerService;
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
        return "OrderAppraiseSellerVO{" +
                "appraiseId=" + appraiseId +
                ", buyer='" + buyer + '\'' +
                ", buyerHeadUrl='" + buyerHeadUrl + '\'' +
                ", seller='" + seller + '\'' +
                ", sellerHeadUrl='" + sellerHeadUrl + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderDescribe='" + orderDescribe + '\'' +
                ", paySpeed=" + paySpeed +
                ", receiveSpeed=" + receiveSpeed +
                ", buyerService=" + buyerService +
                ", appraiseContent='" + appraiseContent + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
