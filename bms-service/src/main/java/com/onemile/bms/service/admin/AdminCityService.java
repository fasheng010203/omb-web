package com.onemile.bms.service.admin;


import com.onemile.bms.entity.admin.AdminCity;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

public interface AdminCityService extends BaseService<AdminCity> {

    /**
     * 根据用户ID查询
     * @param adminCity
     * @return
     */
    AdminCity findByUserId(AdminCity adminCity);


    /**
     * 删除管理城市
     * @param adminCity
     * @return
     */
    int deleteAdminCityByUserIdAndCity(AdminCity adminCity);



    /**
     * 根据用户获取管理的城市
     * @return
     */
    List<AdminCity> listAdminCityByUserId(AdminCity adminCity);


}