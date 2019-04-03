package com.onemile.bms.service.device.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.device.SbRssi;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.device.SbRssiMapper;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.SbRssiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SbRssiServiceImpl extends BaseServiceImpl<SbRssi> implements SbRssiService {
    private Logger logger = LoggerFactory.getLogger(SbRssiServiceImpl.class);

    @Autowired
    private SbRssiMapper sbRssiMapper;

    @Override
    protected BaseMapper<SbRssi> getBaseMapper() {
        return sbRssiMapper;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveSbRssi(SbRssi sbRssi) {

        sbRssi.setGmtCreate(new Date());
        sbRssiMapper.insertSelective(sbRssi);

        return true;
    }

}