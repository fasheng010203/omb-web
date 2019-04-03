package com.onemile.bms.service.admin;

import com.onemile.bms.entity.admin.AdminRole;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminRoleQuery;
import com.onemile.bms.service.base.BaseService;

/**
 * @author Eric
 */
public interface AdminRoleService extends BaseService<AdminRole> {


    /**
     * 分页查询
     *
     * @param adminRoleQuery
     * @return
     */
    PageInfoRsp<AdminRole> listPageByMap(AdminRoleQuery adminRoleQuery);


}