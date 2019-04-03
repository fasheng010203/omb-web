package com.onemile.bms.service.device.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.entity.device.SbStatus;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.device.SbStatusMapper;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.SbStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SbStatusServiceImpl extends BaseServiceImpl<SbStatus> implements SbStatusService {
    private Logger logger = LoggerFactory.getLogger(SbStatusServiceImpl.class);

    @Autowired
    private SbStatusMapper sbStatusMapper;

    @Override
    protected BaseMapper<SbStatus> getBaseMapper() {
        return sbStatusMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveSbStatus(SbStatus sbStatus) {

        sbStatus.setGmtCreate(new Date());
        sbStatusMapper.insertSelective(sbStatus);

        return true;
    }
}