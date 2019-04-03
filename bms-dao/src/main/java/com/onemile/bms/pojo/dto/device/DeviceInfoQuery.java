package com.onemile.bms.pojo.dto.device;

import com.onemile.bms.page.PageReq;


public class DeviceInfoQuery extends PageReq {

    private String devid;
    private String beginDate;
    private String endDate;
    private String title;
    private Integer citypid;

    /**
     * 所属城市Id
     */
    private String cityid;

    public String getDevid() {
        return devid;
    }
    public void setDevid(String devid) { this.devid = devid; }
    public String getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 所属城市Id
     * @return cityid 所属城市Id
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 所属城市Id
     * @param cityid 所属城市Id
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }


    /**
     * 所属城市Id
     * @return citypid 所属城市Id
     */
    public Integer getCitypid() {
        return citypid;
    }

    /**
     * 所属城市Id
     * @param citypid 所属城市Id
     */
    public void setCitypid(Integer citypid) {
        this.citypid = citypid == null ? null : citypid;
    }

}