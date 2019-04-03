package com.onemile.bms.pojo.vo.zxshare.order;


/**
 * @author Eric
 * @date 2018/8/22
 */
public class OrderCarVO {

    private Long orderId;
    private String carNo;
    private String driverName;
    private String driveMobile;
    private String drivingLicenseBack;
    private String drivingLicenseFace;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriveMobile() {
        return driveMobile;
    }

    public void setDriveMobile(String driveMobile) {
        this.driveMobile = driveMobile;
    }

    public String getDrivingLicenseBack() {
        return drivingLicenseBack;
    }

    public void setDrivingLicenseBack(String drivingLicenseBack) {
        this.drivingLicenseBack = drivingLicenseBack;
    }

    public String getDrivingLicenseFace() {
        return drivingLicenseFace;
    }

    public void setDrivingLicenseFace(String drivingLicenseFace) {
        this.drivingLicenseFace = drivingLicenseFace;
    }

    @Override
    public String toString() {
        return "OrderCarVO{" +
                "orderId=" + orderId +
                ", carNo='" + carNo + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driveMobile='" + driveMobile + '\'' +
                ", drivingLicenseBack='" + drivingLicenseBack + '\'' +
                ", drivingLicenseFace='" + drivingLicenseFace + '\'' +
                '}';
    }
}
