package com.onemile.bms.service.device;

import com.onemile.bms.entity.device.SbRssi;
import com.onemile.bms.service.base.BaseService;

public interface SbRssiService extends BaseService<SbRssi> {
    /**
     * 增加
     * @param sbRssib
     * @return
     */
    Boolean saveSbRssi(SbRssi sbRssib);
}

