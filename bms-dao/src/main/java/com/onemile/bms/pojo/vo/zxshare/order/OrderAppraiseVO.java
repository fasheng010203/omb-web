package com.onemile.bms.pojo.vo.zxshare.order;


/**
 * @author Eric
 * @date 2018/8/27
 */
public class OrderAppraiseVO {
    private Integer description;
    private Integer sendSpeed;
    private Integer sellerService;
    private String buyerContent;
    private Integer paySpeed;
    private Integer receiveSpeed;
    private Integer buyerService;
    private String sellerContent;

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

    public String getBuyerContent() {
        return buyerContent;
    }

    public void setBuyerContent(String buyerContent) {
        this.buyerContent = buyerContent;
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

    public String getSellerContent() {
        return sellerContent;
    }

    public void setSellerContent(String sellerContent) {
        this.sellerContent = sellerContent;
    }

    @Override
    public String toString() {
        return "OrderAppraiseVO{" +
                "description=" + description +
                ", sendSpeed=" + sendSpeed +
                ", sellerService=" + sellerService +
                ", buyerContent='" + buyerContent + '\'' +
                ", paySpeed=" + paySpeed +
                ", receiveSpeed=" + receiveSpeed +
                ", buyerService=" + buyerService +
                ", sellerContent='" + sellerContent + '\'' +
                '}';
    }
}
