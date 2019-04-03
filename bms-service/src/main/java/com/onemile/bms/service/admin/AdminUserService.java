package com.onemile.bms.service.admin;


import com.onemile.bms.entity.admin.AdminUser;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminUserQuery;
import com.onemile.bms.pojo.vo.admin.AdminUserRoleVO;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

/**
 * @author Eric
 */
public interface AdminUserService extends BaseService<AdminUser> {

    /**
     * 分页查询
     *
     * @param adminUserQuery
     * @return
     */
    PageInfoRsp<AdminUserVO> listPageByMap(AdminUserQuery adminUserQuery);


    /**
     * 登录名查询
     *
     * @param loginName
     * @return
     */
    AdminUser getByLoginName(String loginName);

    /**
     * 按部门统计人数
     *
     * @param deptId
     * @return
     */
    Integer countByDept(Integer deptId);

    /**
     * 用户分配的角色列表
     * @param userId
     * @return
     */
    List<AdminUserRoleVO> listUserRole(Long userId,Long mchId);

    /**
     * 根据ID和旧密码查询
     * @param userId
     * @param oldLoginPwd
     * @return
     */
    AdminUser selectUserByPwd(Long userId, String oldLoginPwd,Long mchId);


    /**
     * 更改shiro查询新增 mchName 字段用于打印
     *
     * @param loginName
     * @return
     */
    AdminUserVO getAdminUserVO(String loginName);



    /**
     * 获取用户资源
     *
     * @param userId
     * @return
     */
    List<Long> listUserResc(Long userId);

    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    List<Long> listUserRole(Long userId);


}

