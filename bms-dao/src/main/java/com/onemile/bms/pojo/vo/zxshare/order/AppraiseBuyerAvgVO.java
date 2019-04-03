package com.onemile.bms.pojo.vo.zxshare.order;

/**
 * @author Eric
 * @date 2018/8/28
 */
public class AppraiseBuyerAvgVO {

    private Integer description;
    private Integer sendSpeed;
    private Integer sellerService;

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

    @Override
    public String toString() {
        return "AppraiseBuyerAvgVO{" +
                "description=" + description +
                ", sendSpeed=" + sendSpeed +
                ", sellerService=" + sellerService +
                '}';
    }
}
