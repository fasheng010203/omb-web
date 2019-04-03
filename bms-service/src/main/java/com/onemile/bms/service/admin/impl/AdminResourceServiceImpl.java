package com.onemile.bms.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminResource;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminResourceMapper;
import com.onemile.bms.mapper.admin.AdminRoleResourceMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.vo.admin.AdminMenuVO;
import com.onemile.bms.service.admin.AdminResourceService;
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
public class AdminResourceServiceImpl extends BaseServiceImpl<AdminResource> implements AdminResourceService {
    private Logger logger = LoggerFactory.getLogger(AdminResourceServiceImpl.class);

    @Autowired
    private AdminResourceMapper adminResourceMapper;
    @Autowired
    private AdminRoleResourceMapper resourceMapper;

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    protected BaseMapper<AdminResource> getBaseMapper() {
        return adminResourceMapper;
    }


    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminResource> listRecource(Integer type, Long pid) {
        return adminResourceMapper.listRecource(type, pid);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public PageInfoRsp<AdminResource> listPageByMap(Long pid) {

        PageInfo<AdminResource> pageInfo = PageHelper.startPage(1, 100).doSelectPageInfo(() -> adminResourceMapper.listRecource(null, pid));

        PageInfoRsp<AdminResource> pageInfoRsp = PageInfoConverts.convert(pageInfo);

        return pageInfoRsp;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public Boolean checkCode(Long appId, String code) {
        Integer count = adminResourceMapper.countByCode(1L, code);
        if (count != null && count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public Long getMaxId(Long pid) {
        return adminResourceMapper.getMaxId(pid);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminMenuVO> listUserMenuResc(Long userId, Integer isSuper) {
        return adminResourceMapper.selectUserRoleResource(userId, isSuper);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public Integer countChildMenus(Long pid) {
        return adminResourceMapper.countChildMenus(pid);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    @Transactional(value = "txManagerBms", rollbackFor = Exception.class)
    public void deleteResource(Long id, List<Long> actionIds) {
        adminResourceMapper.deleteByPrimaryKey(id);
        //删除子项
        adminResourceMapper.deleteByPid(id);
        // 删除role_resource
        actionIds.add(id);
        resourceMapper.batchDelete(actionIds);
    }


}