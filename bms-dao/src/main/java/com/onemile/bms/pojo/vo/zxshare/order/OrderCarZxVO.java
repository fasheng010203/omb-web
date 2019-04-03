package com.onemile.bms.pojo.vo.zxshare.order;

import java.math.BigDecimal;

/**
 * @author Eric
 * @date 2018/8/22
 */
public class OrderCarZxVO {

    private Long orderId;
    private String carEmptyUrl;
    private String carFullUrl;
    private String carWeightUrl;
    private BigDecimal weight;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCarEmptyUrl() {
        return carEmptyUrl;
    }

    public void setCarEmptyUrl(String carEmptyUrl) {
        this.carEmptyUrl = carEmptyUrl;
    }

    public String getCarFullUrl() {
        return carFullUrl;
    }

    public void setCarFullUrl(String carFullUrl) {
        this.carFullUrl = carFullUrl;
    }

    public String getCarWeightUrl() {
        return carWeightUrl;
    }

    public void setCarWeightUrl(String carWeightUrl) {
        this.carWeightUrl = carWeightUrl;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "OrderCarZxVO{" +
                "orderId=" + orderId +
                ", carEmptyUrl='" + carEmptyUrl + '\'' +
                ", carFullUrl='" + carFullUrl + '\'' +
                ", carWeightUrl='" + carWeightUrl + '\'' +
                ", weight=" + weight +
                '}';
    }
}
