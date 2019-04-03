package com.onemile.bms.mapper.admin;


import com.onemile.bms.entity.admin.AdminUser;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.admin.AdminUserRoleVO;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Eric
 */
@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<AdminUserVO> listPage(Map<String, Object> map);

    /**
     * 登录名查询
     *
     * @param loginName
     * @return
     */
    AdminUser selectByLoginName(@Param("loginName") String loginName);

    /**
     * 统计部门下人数
     *
     * @param deptId
     * @return
     */
    Integer countByDept(@Param("deptId") Integer deptId);


    /**
     * 用户分配的角色列表
     * @param userId
     * @param mchId
     * @return
     */
    List<AdminUserRoleVO> listUserRole(@Param("userId") Long userId, @Param("mchId")Long mchId);


    /**
     * 更改shiro查询新增 mchName 字段用于打印
     *
     * @param loginName
     * @return
     */
    AdminUserVO getAdminUserVO(@Param("loginName") String loginName);

    /**
     * 查询原密码是否正确
     * @param userId
     * @param oldLoginPwd
     * @return
     */
    AdminUser selectUserByPwd(@Param("userId")Long userId,@Param("oldLoginPwd") String oldLoginPwd,@Param("mchId")Long mchId);
}