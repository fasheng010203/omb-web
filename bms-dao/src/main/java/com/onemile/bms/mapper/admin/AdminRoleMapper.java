package com.onemile.bms.mapper.admin;

import com.onemile.bms.entity.admin.AdminRole;
import com.onemile.bms.entity.admin.AdminRole;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.entity.admin.AdminRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Eric
 */
@Repository
public interface AdminRoleMapper extends BaseMapper<AdminRole> {


    /**
     * 分页查询列表
     *
     * @param map
     * @return
     */
    List<AdminRole> listPage(Map<String, Object> map);

    /**
     * 分组统计商户角色包含用户数量
     *
     * @param mchId
     * @return
     */
    List<AdminRole> CountRoleUsers(Long mchId);


    /**
     * 批量更新商户下角色包含用户
     *
     * @param mchId
     * @return
     */
    Integer updateUserCnt(Long mchId);

}