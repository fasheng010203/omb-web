package com.onemile.bms.shiro;

import com.onemile.bms.pojo.vo.admin.AdminUserVO;

import java.util.List;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/11
 */
public interface ShiroService {


    /**
     * 更改shiro查询新增 mchName 字段用于打印
     *
     * @param loginName
     * @return
     */
    AdminUserVO getAdminUserVO(String loginName);


    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    List<Long> listUserRole(Long userId);

    /**
     * 获取用户资源
     *
     * @param userId
     * @return
     */
    List<Long> listUserResc(Long userId);


}
