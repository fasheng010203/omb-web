package com.onemile.bms.service.admin.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminCity;
import com.onemile.bms.entity.device.DeviceInfo;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminCityMapper;
import com.onemile.bms.service.admin.AdminCityService;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCityServiceImpl extends BaseServiceImpl<AdminCity> implements AdminCityService {
    private Logger logger = LoggerFactory.getLogger(AdminCityServiceImpl.class);

    @Autowired
    private AdminCityMapper adminCityMapper;

    @Override
    protected BaseMapper<AdminCity> getBaseMapper() {
        return adminCityMapper;
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public AdminCity findByUserId(AdminCity adminCity) {
        return adminCityMapper.findAdminCity(adminCity);
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public int deleteAdminCityByUserIdAndCity(AdminCity adminCity) {
        return adminCityMapper.deleteAdminCityByUserIdAndCity(adminCity);
    }

    /**
     * 根据用户获取管理的城市
     * @return
     */
    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List<AdminCity> listAdminCityByUserId(AdminCity adminCity) {
        return adminCityMapper.listAdminCityByUserId(adminCity);
    }


}