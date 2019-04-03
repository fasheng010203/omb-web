package com.onemile.bms.service.device;

import com.onemile.bms.entity.device.SbStatus;
import com.onemile.bms.service.base.BaseService;

public interface SbStatusService extends BaseService<SbStatus> {

    /**
     * 增加
     * @param sbStatus
     * @return
     */
    Boolean saveSbStatus(SbStatus sbStatus);
}