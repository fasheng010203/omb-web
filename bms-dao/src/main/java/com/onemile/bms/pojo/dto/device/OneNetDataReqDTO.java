package com.onemile.bms.pojo.dto.device;

import java.util.List;

/**
 * @author ericma
 */
public class OneNetDataReqDTO {

    private String per_page;
    private String total_count;
    private String page;
    private List<OneNetDeviceInfoReqDTO> devices;

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<OneNetDeviceInfoReqDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<OneNetDeviceInfoReqDTO> devices) {
        this.devices = devices;
    }
}
