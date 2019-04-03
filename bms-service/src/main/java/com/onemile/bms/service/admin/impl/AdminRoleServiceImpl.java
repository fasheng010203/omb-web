package com.onemile.bms.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminRole;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminRoleMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminRoleQuery;
import com.onemile.bms.service.admin.AdminRoleService;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 */
@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements AdminRoleService {
    private Logger logger = LoggerFactory.getLogger(AdminRoleServiceImpl.class);

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    protected BaseMapper<AdminRole> getBaseMapper() {
        return adminRoleMapper;
    }


    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public PageInfoRsp<AdminRole> listPageByMap(AdminRoleQuery adminRoleQuery) {
        //查询条件
        Map<String, Object> map = new HashMap<>(6);
        map.put("mchId", adminRoleQuery.getMchId());
        map.put("roleName", adminRoleQuery.getRoleName());
        map.put("beginDate", adminRoleQuery.getBeginDate());
        map.put("endDate", adminRoleQuery.getEndDate());

        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(adminRoleQuery.getSidx())) {
            strOrderBy = adminRoleQuery.getSidx() + " " + adminRoleQuery.getSord();
        }

        PageInfo<AdminRole> pageInfo = PageHelper.startPage(adminRoleQuery.getPage(), adminRoleQuery.getRows(), strOrderBy).doSelectPageInfo(() -> adminRoleMapper.listPage(map));
        PageInfoRsp<AdminRole> pageInfoRsp = PageInfoConverts.convert(pageInfo);

        return pageInfoRsp;
    }


}