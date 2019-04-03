package com.onemile.bms.service.device;

import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.entity.device.SbRssi;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

public interface SbLocService extends BaseService<SbLoc> {

    /**
     * 增加
     * @param sbLoc
     * @return
     */
    Boolean saveSbLoc(SbLoc sbLoc);

    /**
     * 列表
     * @param deviceEventQuery
     * @return
     */
    PageInfoRsp<SbLoc> getDeviceLocList(DeviceEventQuery deviceEventQuery);



    /**
     * 所有设备地址列表
     * @param
     * @return
     */
    List<SbLoc> getDeviceLocShowList();
}
