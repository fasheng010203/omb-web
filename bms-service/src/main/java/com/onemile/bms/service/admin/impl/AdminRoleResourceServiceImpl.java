package com.onemile.bms.service.admin.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminRoleResource;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminRoleResourceMapper;
import com.onemile.bms.pojo.vo.admin.AdminRoleRescVO;
import com.onemile.bms.service.admin.AdminRoleResourceService;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Eric
 */
@Service
public class AdminRoleResourceServiceImpl extends BaseServiceImpl<AdminRoleResource> implements AdminRoleResourceService {
    private Logger logger = LoggerFactory.getLogger(AdminRoleResourceServiceImpl.class);

    @Autowired
    private AdminRoleResourceMapper adminRoleResourceMapper;

    @Override
    protected BaseMapper<AdminRoleResource> getBaseMapper() {
        return adminRoleResourceMapper;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminRoleRescVO> listRoleResc(Long roleId) {
        return adminRoleResourceMapper.selectAdminRoleResource(roleId);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminRoleRescVO> listRoleRescByPids(List<Long> pids, Long roleId) {
        return adminRoleResourceMapper.selectAdminRoleResourceByPids(pids, roleId);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    @Transactional(value = "txManagerBms", rollbackFor = Exception.class)
    public Integer saveBatch(List<AdminRoleResource> adminRoleResourceList, Long roleId) {
        adminRoleResourceMapper.deleteByRoleId(roleId);
        return adminRoleResourceMapper.batchInsert(adminRoleResourceList);
    }

}