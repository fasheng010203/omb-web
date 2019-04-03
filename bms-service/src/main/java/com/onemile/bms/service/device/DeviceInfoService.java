package com.onemile.bms.service.device;

import com.onemile.bms.entity.device.DeviceInfo;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.DeviceInfoDTO;
import com.onemile.bms.pojo.dto.device.DeviceInfoQuery;
import com.onemile.bms.pojo.dto.device.DeviceInfoReq;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

public interface DeviceInfoService extends BaseService<DeviceInfo> {

    /**
     * 列表
     * @param deviceInfoQuery
     * @return
     */
    PageInfoRsp<DeviceInfoDTO> getDeviceInfoList(DeviceInfoQuery deviceInfoQuery);

    /**
     * 增加
     * @param deviceInfoReq
     * @return
     */
    Boolean saveDeviceInfo(DeviceInfoReq deviceInfoReq);

    /**
     * 根据鉴权号查询
     * @param autoInfo
     * @return
     */
    DeviceInfo findByAutoInfo(String autoInfo);


    /**
     * 更新数据
     * @param deviceInfo
     * @return
     */
    Boolean updateDeviceInfo(DeviceInfo deviceInfo);


    /**
     * 获取设备总数
     * @param
     * @return
     */
    Long getDeviceCount();

    /**
     * 获取待维修设备数量
     * @param
     * @return
     */
    Long getDeviceFixCount();

    /**
     * 查询所有设备数据
     *
     * @param
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
     * 根据鉴权信息更新设备
     * @param deviceInfo
     * @return
     */
    Integer updateDeviceByAuthinfo(DeviceInfo deviceInfo);

}