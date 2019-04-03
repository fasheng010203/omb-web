package com.onemile.bms.service.device;

import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

public interface SbEventService extends BaseService<SbEvent> {

    /**
     * 列表
     * @param deviceEventQuery
     * @return
     */
    PageInfoRsp<SbEvent> getDeviceEventList(DeviceEventQuery deviceEventQuery);


    /**
     * 增加
     * @param sbEvent
     * @return
     */
    Boolean saveSbEvent(SbEvent sbEvent);


    /**
     * 查询所有设备数据
     *
     * @param
     * @return
     */
    List<SbEvent> listDeviceEvt();

}