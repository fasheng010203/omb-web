package com.onemile.bms.service.device.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.device.DeviceInfo;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.device.DeviceInfoMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import com.onemile.bms.pojo.dto.device.DeviceInfoQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoReq;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.DeviceInfoService;
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
public class DeviceInfoServiceImpl extends BaseServiceImpl<DeviceInfo> implements DeviceInfoService {
    private Logger logger = LoggerFactory.getLogger(DeviceInfoServiceImpl.class);

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    protected BaseMapper<DeviceInfo> getBaseMapper() {
        return deviceInfoMapper;
    }



    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<DeviceInfoDTO> getDeviceInfoList(DeviceInfoQuery deviceInfoQuery) {
        Map<String, Object> map = new HashMap<>(7);
        map.put("title", deviceInfoQuery.getTitle());
        map.put("devid", deviceInfoQuery.getDevid());
        map.put("beginDate", deviceInfoQuery.getBeginDate());
        map.put("endDate", deviceInfoQuery.getEndDate());
        map.put("cityid", deviceInfoQuery.getCityid());

        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(deviceInfoQuery.getSidx())) {
            strOrderBy = deviceInfoQuery.getSidx() + " " + deviceInfoQuery.getSord();
        }
        PageInfo<DeviceInfoDTO> appVersionVOPageInfo = PageHelper.startPage(deviceInfoQuery.getPage(), deviceInfoQuery.getRows(), strOrderBy).doSelectPageInfo(() -> deviceInfoMapper.listPage(map));
        PageInfoRsp<DeviceInfoDTO> pageInfoRsp = PageInfoConverts.convert(appVersionVOPageInfo);

        return pageInfoRsp;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveDeviceInfo(DeviceInfoReq deviceInfoReq) {

        DeviceInfo deviceInfo=new DeviceInfo();
        deviceInfo.setAuthInfo(deviceInfoReq.getAuthInfo());
        deviceInfo.setDevdesc(deviceInfoReq.getDevdesc());
        deviceInfo.setDevId(deviceInfoReq.getDevId());
        deviceInfo.setTitle(deviceInfoReq.getTitle());
        deviceInfo.setQrurl(deviceInfoReq.getQrurl());
        deviceInfo.setOnline(deviceInfoReq.getOnline());

        deviceInfo.setProtocol("MQTT");
        deviceInfo.setSbprivate("true");
        deviceInfo.setGmtModified(new Date());
        deviceInfo.setGmtCreate(new Date());
        deviceInfoMapper.insertSelective(deviceInfo);

        return true;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public DeviceInfo findByAutoInfo(String authInfo) {
        return deviceInfoMapper.findByAutoInfo(authInfo);
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean updateDeviceInfo(DeviceInfo deviceInfo) {
        deviceInfoMapper.updateByPrimaryKeySelective(deviceInfo);
        return true;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Long getDeviceCount() {
        return deviceInfoMapper.getDeviceCount();
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Long getDeviceFixCount() {
        return deviceInfoMapper.getDeviceFixCount();
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List listDeviceInfo() {
        return deviceInfoMapper.listDeviceInfo();
    }

    @Override
    public Integer updateDeviceByDevId(DeviceInfo deviceInfo) {

        return deviceInfoMapper.updateDeviceByDevId(deviceInfo);
    }

    @Override
    public Integer updateDeviceByAuthinfo(DeviceInfo deviceInfo) {
        return deviceInfoMapper.updateDeviceByAuthinfo(deviceInfo);
    }


}