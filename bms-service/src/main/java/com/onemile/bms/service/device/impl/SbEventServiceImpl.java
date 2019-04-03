package com.onemile.bms.service.device.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.device.SbEvent;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.device.SbEventMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.SbEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SbEventServiceImpl extends BaseServiceImpl<SbEvent> implements SbEventService {
    private Logger logger = LoggerFactory.getLogger(SbEventServiceImpl.class);

    @Autowired
    private SbEventMapper sbEventMapper;

    @Override
    protected BaseMapper<SbEvent> getBaseMapper() {
        return sbEventMapper;
    }



    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveSbEvent(SbEvent sbEvent) {

        sbEvent.setGmtCreate(new Date());
        sbEventMapper.insertSelective(sbEvent);

        return true;
    }




    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<SbEvent> getDeviceEventList(DeviceEventQuery deviceEventQuery) {
        Map<String, Object> map = new HashMap<>(7);
        map.put("title", deviceEventQuery.getTitle());
        map.put("devid", deviceEventQuery.getDevid());
        map.put("beginDate", deviceEventQuery.getBeginDate());
        map.put("endDate", deviceEventQuery.getEndDate());


        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(deviceEventQuery.getSidx())) {
            strOrderBy = deviceEventQuery.getSidx() + " " + deviceEventQuery.getSord();
        }
        PageInfo<SbEvent> appVersionVOPageInfo = PageHelper.startPage(deviceEventQuery.getPage(), deviceEventQuery.getRows(), strOrderBy).doSelectPageInfo(() -> sbEventMapper.listPage(map));
        PageInfoRsp<SbEvent> pageInfoRsp = PageInfoConverts.convert(appVersionVOPageInfo);

        return pageInfoRsp;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List<SbEvent> listDeviceEvt() {
        return sbEventMapper.listDeviceEvt();
    }



}