package com.onemile.bms.mapper.device;

import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface SbEventMapper extends BaseMapper<SbEvent> {

    List<SbEvent> listPage(Map<String,Object> map);

    /**
     * 获取所有设备事件信息
     * @return
     */
    List<SbEvent> listDeviceEvt();
}