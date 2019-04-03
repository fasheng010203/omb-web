package com.onemile.bms.service.admin;

import com.onemile.bms.entity.admin.AdminRoleResource;
import com.onemile.bms.pojo.vo.admin.AdminRoleRescVO;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

/**
 * @author Eric
 */
public interface AdminRoleResourceService extends BaseService<AdminRoleResource> {


    /**
     * 查询角色分配资源时的菜单资源list
     *
     * @param roleId
     * @return
     */
    List<AdminRoleRescVO> listRoleResc(Long roleId);


    /**
     * roleResource 角色分配权限时 选中菜单 的 action
     *
     * @param pids
     * @param roleId
     * @return
     */
    List<AdminRoleRescVO> listRoleRescByPids(List<Long> pids, Long roleId);


    /**
     * 批量保存角色的资源
     *
     * @param adminRoleResourceList 选中的资源
     * @param roleId                角色id
     * @return
     */
    Integer saveBatch(List<AdminRoleResource> adminRoleResourceList, Long roleId);

}