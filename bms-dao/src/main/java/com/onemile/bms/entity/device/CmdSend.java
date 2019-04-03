package com.onemile.bms.entity.device;

public class CmdSend {

    // 设备imei号，平台唯一，必填参数
    private String errno;
    // ISPO标准中的Object ID
    protected String error;
    // ISPO标准中的Object Instance ID
    protected Data data;

    /**
     * 设备名称
     * @return errno 设备名称
     */
    public String getErrno() {
        return errno;
    }

    /**
     * 设备名称
     * @param errno 设备名称
     */
    public void setErrno(String errno) {
        this.errno = errno == null ? null : errno.trim();
    }

    /**
     * 设备名称
     * @return error 设备名称
     */
    public String getError() {
        return error;
    }

    /**
     * 设备名称
     * @param error 设备名称
     */
    public void setError(String error) {
        this.error = error == null ? null : error.trim();
    }


    /**
     * 设备名称
     * @return error 设备名称
     */
    public Data getData() {
        return data;
    }

    /**
     * 设备名称
     * @param data 设备名称
     */
    public void setData(Data data) {
        this.data = data;
    }

}
