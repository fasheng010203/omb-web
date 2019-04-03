package com.onemile.bms.service.admin;

import com.onemile.bms.entity.admin.AdminUserRole;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

/**
 * @author Eric
 */
public interface AdminUserRoleService extends BaseService<AdminUserRole> {

    /**
     * 批量添加用户角色
     *
     * @param userId  用户id
     * @param roleIds 角色list
     * @param mchId   所属商户（主要用于批量更新该商户下所有角色包含用户数量）
     * @return
     */
    Integer insertUserRoles(Long userId, List<Long> roleIds, Long mchId);

    /**
     * 统计角色下用户数量
     *
     * @param roleId
     * @return
     */
    Integer countByRoleId(Long roleId);
}