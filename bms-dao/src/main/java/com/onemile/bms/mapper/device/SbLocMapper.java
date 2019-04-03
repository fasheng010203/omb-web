package com.onemile.bms.mapper.device;

import com.onemile.bms.entity.device.SbLoc;
import com.onemile.bms.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface SbLocMapper extends BaseMapper<SbLoc> {

    List<SbLoc> listPage(Map<String,Object> map);

    List<SbLoc> getDeviceLocShow();




}