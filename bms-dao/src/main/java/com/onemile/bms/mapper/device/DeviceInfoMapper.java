package com.onemile.bms.mapper.device;

import com.onemile.bms.entity.device.DeviceInfo;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import io.lettuce.core.dynamic.annotation.Param;


import java.util.List;
import java.util.Map;

public interface DeviceInfoMapper extends BaseMapper<DeviceInfo> {

    List<DeviceInfoDTO> listPage(Map<String,Object> map);

    DeviceInfo findByAutoInfo(@Param("authInfo")String authInfo);

    /**
     * 设备总数数
     * @return
     */
    Long getDeviceCount();

    /**
     * 待维修设备总数数
     * @return
     */
    Long getDeviceFixCount();


    /**
     * 获取所有设备信息进行统计
     * @return
     */
    List<DeviceInfoDTO> listDeviceInfo();


    /**
     * 根据设备ID更新设备状态
     * @param deviceInfo
     * @return
     */
    Integer updateDeviceByDevId(DeviceInfo deviceInfo);


    /**
     * 根据鉴权信息更新设备状态
     * @param deviceInfo
     * @return
     */
    Integer updateDeviceByAuthinfo(DeviceInfo deviceInfo);


}