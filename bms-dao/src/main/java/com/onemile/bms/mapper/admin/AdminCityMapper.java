package com.onemile.bms.mapper.admin;


import com.onemile.bms.entity.admin.AdminCity;
import com.onemile.bms.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AdminCityMapper extends BaseMapper<AdminCity> {

    /**
     * 获取管理城市
     * @return
     */
    AdminCity findAdminCity(AdminCity adminCity);


    /**
     * 删除管理城市
     * @return
     */
    int deleteAdminCityByUserIdAndCity(AdminCity adminCity);


    /**
     * 根据用户获取管理的城市
     * @return
     */
    List<AdminCity> listAdminCityByUserId(AdminCity adminCity);






}