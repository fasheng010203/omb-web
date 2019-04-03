package com.onemile.bms.pojo.dto.device;

import java.util.List;

/**
 * @author ericma
 */
public class OneNetDeviceReqDTO {

    private String errno;
    private String error;
    private OneNetDataReqDTO data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public OneNetDataReqDTO getData() {
        return data;
    }

    public void setData(OneNetDataReqDTO data) {
        this.data = data;
    }
}



