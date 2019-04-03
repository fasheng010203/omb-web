package com.onemile.bms.service.device.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.entity.device.SbRssi;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.device.SbLocMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceEventQuery;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.SbLocService;
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
public class SbLocServiceImpl extends BaseServiceImpl<SbLoc> implements SbLocService {
    private Logger logger = LoggerFactory.getLogger(SbLocServiceImpl.class);

    @Autowired
    private SbLocMapper sbLocMapper;

    @Override
    protected BaseMapper<SbLoc> getBaseMapper() {
        return sbLocMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveSbLoc(SbLoc sbLoc) {

        sbLoc.setGmtCreate(new Date());
        sbLocMapper.insertSelective(sbLoc);

        return true;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<SbLoc> getDeviceLocList(DeviceEventQuery deviceEventQuery) {
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
        PageInfo<SbLoc> appVersionVOPageInfo = PageHelper.startPage(deviceEventQuery.getPage(), deviceEventQuery.getRows(), strOrderBy).doSelectPageInfo(() -> sbLocMapper.listPage(map));
        PageInfoRsp<SbLoc> pageInfoRsp = PageInfoConverts.convert(appVersionVOPageInfo);

        return pageInfoRsp;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List<SbLoc> getDeviceLocShowList() {

        Map<String, Object> map = new HashMap<>(7);

        List<SbLoc> listDevLocShow=sbLocMapper.getDeviceLocShow();

        return listDevLocShow;
    }







}