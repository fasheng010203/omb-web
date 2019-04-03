package com.onemile.bms.pojo.dto.device;

import com.onemile.bms.utils.DateUtil;

public class OneNetMsgReqDTO {

    private String type;
    private String dev_id;
    private String ds_id;
    private String at;
    private String value;
    private String status;
    private String login_type;
    private String attime;

    public String getType() {
        return type;
    }
    public void setType(String type) { this.type = type; }


    public String getDev_id() {
        return dev_id;
    }
    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }


    public String getDs_id() {
        return ds_id;
    }
    public void setDs_id(String ds_id) {
        this.ds_id = ds_id;
    }

    public String getAt() {
        return at;
    }
    public void setAt(String at) {
        this.at = at;
    }


    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.at = status;
    }


    public String getLogin_type() {
        return login_type;
    }
    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

    public String getAttime() {
        return DateUtil.timeStamp2Date(at,"yyyy-MM-dd HH:mm:ss");
    }

}
