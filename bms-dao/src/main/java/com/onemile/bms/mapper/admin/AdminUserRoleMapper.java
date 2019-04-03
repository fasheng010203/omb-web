package com.onemile.bms.mapper.admin;

import com.onemile.bms.entity.admin.AdminUserRole;
import com.onemile.bms.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 */
@Repository
public interface AdminUserRoleMapper extends BaseMapper<AdminUserRole> {

    /**
     * 用户拥有角色
     *
     * @param userId
     * @return
     */
    List<Long> selectUserRoles(Long userId);

    /**
     * 用户拥有 资源
     *
     * @param userId
     * @return
     */
    List<Long> selectUserResc(Long userId);

    /**
     * 按用户id删除
     *
     * @param userId
     * @return
     */
    Integer deleteByUserId(Long userId);

    /**
     * 批量插入
     *
     * @param adminUserRoles
     * @return
     */
    Integer batchInsert(List<AdminUserRole> adminUserRoles);

    /**
     * 统计角色下用户数量
     *
     * @param RoleId
     * @return
     */
    Integer countByRoleId(Long RoleId);

}