package com.onemile.bms.service.admin.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminUserRole;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminRoleMapper;
import com.onemile.bms.mapper.admin.AdminUserRoleMapper;
import com.onemile.bms.service.admin.AdminUserRoleService;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Eric
 */
@Service
public class AdminUserRoleServiceImpl extends BaseServiceImpl<AdminUserRole> implements AdminUserRoleService {
    private Logger logger = LoggerFactory.getLogger(AdminUserRoleServiceImpl.class);

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    protected BaseMapper<AdminUserRole> getBaseMapper() {
        return adminUserRoleMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    @Transactional(value = "txManagerBms", rollbackFor = Exception.class)
    public Integer insertUserRoles(Long userId, List<Long> roleIds, Long mchId) {

        List<AdminUserRole> adminUserRoleList = new ArrayList<>();
        for (Long roleId : roleIds) {
            AdminUserRole adminUserRole = new AdminUserRole();
            adminUserRole.setRoleId(roleId);
            adminUserRole.setUserId(userId);
            adminUserRole.setGmtCreate(new Date());
            adminUserRole.setGmtModified(new Date());
            adminUserRoleList.add(adminUserRole);

        }
        // 删除历史
        adminUserRoleMapper.deleteByUserId(userId);
        //插入新数据
        Integer result = adminUserRoleMapper.batchInsert(adminUserRoleList);
        //更新角色下用户数量
        adminRoleMapper.updateUserCnt(mchId);
        return result;

    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Integer countByRoleId(Long roleId) {
        return adminUserRoleMapper.countByRoleId(roleId);
    }


}