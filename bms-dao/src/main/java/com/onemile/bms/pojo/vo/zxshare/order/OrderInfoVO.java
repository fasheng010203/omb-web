package com.onemile.bms.pojo.vo.zxshare.order;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Eric
 * @date 2018/8/15
 */
public class OrderInfoVO {

    private Integer orderType;
    private Integer conversionType;
    private Long orderNo;
    private String buyUserId;
    private String buyName;
    private String saleUserId;
    private String saleName;
    private Long goodsId;
    private String goodsName;
    private String amountUnit;
    private Integer categoryId;
    private String categoryName;
    private Integer quality;
    private Integer qualitySpecId;
    private String qualitySpecName;
    private List<OrderItemVO> itemList;
    private BigDecimal totalAmount;
    private BigDecimal totalWeight;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal payAmount;
    private Integer payType;
    private Date payTime;
    private String consignee;
    private String mobile;
    private String address;
    private String remark;
    private Integer orderStatus;
    private Integer tradeStatus;
    private Integer estimateStatus;
    private Date createTime;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getConversionType() {
        return conversionType;
    }

    public void setConversionType(Integer conversionType) {
        this.conversionType = conversionType;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(String buyUserId) {
        this.buyUserId = buyUserId;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getQualitySpecId() {
        return qualitySpecId;
    }

    public void setQualitySpecId(Integer qualitySpecId) {
        this.qualitySpecId = qualitySpecId;
    }

    public String getQualitySpecName() {
        return qualitySpecName;
    }

    public void setQualitySpecName(String qualitySpecName) {
        this.qualitySpecName = qualitySpecName;
    }

    public List<OrderItemVO> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItemVO> itemList) {
        this.itemList = itemList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Integer getEstimateStatus() {
        return estimateStatus;
    }

    public void setEstimateStatus(Integer estimateStatus) {
        this.estimateStatus = estimateStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "orderType=" + orderType +
                ", conversionType=" + conversionType +
                ", orderNo=" + orderNo +
                ", buyUserId='" + buyUserId + '\'' +
                ", buyName='" + buyName + '\'' +
                ", saleUserId='" + saleUserId + '\'' +
                ", saleName='" + saleName + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", amountUnit='" + amountUnit + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", quality=" + quality +
                ", qualitySpecId=" + qualitySpecId +
                ", qualitySpecName='" + qualitySpecName + '\'' +
                ", itemList=" + itemList +
                ", totalAmount=" + totalAmount +
                ", totalWeight=" + totalWeight +
                ", price=" + price +
                ", amount=" + amount +
                ", payAmount=" + payAmount +
                ", payType=" + payType +
                ", payTime=" + payTime +
                ", consignee='" + consignee + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", orderStatus=" + orderStatus +
                ", tradeStatus=" + tradeStatus +
                ", estimateStatus=" + estimateStatus +
                ", createTime=" + createTime +
                '}';
    }
}
