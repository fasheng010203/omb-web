package com.onemile.bms.mapper.admin;

import com.onemile.bms.entity.admin.AdminRoleResource;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.admin.AdminRoleRescVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 */
@Repository
public interface AdminRoleResourceMapper extends BaseMapper<AdminRoleResource> {

    /**
     * 查询角色分配资源时的菜单资源list
     *
     * @param roleId 角色id
     * @return
     */
    List<AdminRoleRescVO> selectAdminRoleResource(Long roleId);

    /**
     * 查询选中菜单操作按钮
     *
     * @param pids
     * @param roleId
     * @return
     */
    List<AdminRoleRescVO> selectAdminRoleResourceByPids(@Param("pids") List<Long> pids, @Param("roleId") Long roleId);

    /**
     * 删除角色的所有资源
     *
     * @param roleId
     * @return
     */
    Integer deleteByRoleId(Long roleId);

    /**
     * 批量插入
     *
     * @param adminRoleResourceList
     * @return
     */
    Integer batchInsert(List<AdminRoleResource> adminRoleResourceList);

    /**
     * 批量删除 resid
     *
     * @param resIdList
     * @return
     */
    Integer batchDelete(@Param("resIdList") List<Long> resIdList);
}