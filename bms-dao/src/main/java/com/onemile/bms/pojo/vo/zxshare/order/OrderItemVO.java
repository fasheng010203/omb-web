package com.onemile.bms.pojo.vo.zxshare.order;


/**
 * @author Eric
 * @date 2018/8/15
 */
public class OrderItemVO {
    private Integer specCode;
    private String specName;
    private Integer amount;
    private String unit;

    public Integer getSpecCode() {
        return specCode;
    }

    public void setSpecCode(Integer specCode) {
        this.specCode = specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "OrderItemVO{" +
                "specCode=" + specCode +
                ", specName='" + specName + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
