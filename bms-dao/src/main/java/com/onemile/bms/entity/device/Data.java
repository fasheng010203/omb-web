package com.onemile.bms.entity.device;

public class Data {

    private String cmd_uuid;
    private String device_id;

    /**
     * 设备名称
     * @return cmd_uuid 设备名称
     */
    public String getCmd_uuid() {
        return cmd_uuid;
    }

    /**
     * 设备名称
     * @param cmd_uuid 设备名称
     */
    public void setCmd_uuid(String cmd_uuid) {
        this.cmd_uuid = cmd_uuid == null ? null : cmd_uuid.trim();
    }


    /**
     * 设备名称
     * @return device_id 设备名称
     */
    public String getDevice_id() {
        return device_id;
    }

    /**
     * 设备名称
     * @param device_id 设备名称
     */
    public void setDevice_id(String device_id) {
        this.device_id = device_id == null ? null : device_id.trim();
    }



}
