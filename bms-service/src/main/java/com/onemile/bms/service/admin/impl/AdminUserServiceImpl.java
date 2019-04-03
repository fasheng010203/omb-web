package com.onemile.bms.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminUser;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminUserMapper;
import com.onemile.bms.mapper.admin.AdminUserRoleMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminUserQuery;
import com.onemile.bms.pojo.vo.admin.AdminUserRoleVO;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.service.admin.AdminDeptService;
import com.onemile.bms.service.admin.AdminUserService;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eric
 */
@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser> implements AdminUserService {

    private Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminDeptService adminDeptService;

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

    @Override
    protected BaseMapper<AdminUser> getBaseMapper() {
        return adminUserMapper;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public PageInfoRsp<AdminUserVO> listPageByMap(AdminUserQuery adminUserQuery) {

        //查询条件
        Map<String, Object> map = new HashMap<>(6);
        map.put("mchId", adminUserQuery.getMchId());
        map.put("userName", adminUserQuery.getUserName());
        map.put("status", adminUserQuery.getStatus());

        if (adminUserQuery.getDeptId() != null) {
            List<Integer> deptIds = adminDeptService.listChilds(adminUserQuery.getDeptId());
            deptIds.add(adminUserQuery.getDeptId());
            map.put("deptIds", deptIds);
        }
        map.put("roleId", adminUserQuery.getRoleId());
        map.put("beginDate", adminUserQuery.getBeginDate());
        map.put("endDate", adminUserQuery.getEndDate());

        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(adminUserQuery.getSidx())) {
            strOrderBy = adminUserQuery.getSidx() + " " + adminUserQuery.getSord();
        }

        PageInfo<AdminUserVO> pageInfo = PageHelper.startPage(adminUserQuery.getPage(), adminUserQuery.getRows(), strOrderBy).doSelectPageInfo(() -> adminUserMapper.listPage(map));

        PageInfoRsp<AdminUserVO> pageInfoRsp = PageInfoConverts.convert(pageInfo);

        return pageInfoRsp;
    }


    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public AdminUser getByLoginName(String loginName) {
        return adminUserMapper.selectByLoginName(loginName);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public Integer countByDept(Integer deptId) {
        return adminUserMapper.countByDept(deptId);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminUserRoleVO> listUserRole(Long userId, Long mchId) {
        return adminUserMapper.listUserRole(userId, mchId);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public AdminUser selectUserByPwd(Long userId, String oldLoginPwd, Long mchId) {
        return adminUserMapper.selectUserByPwd(userId, oldLoginPwd, mchId);
    }

    @Override
    public AdminUserVO getAdminUserVO(String loginName) {
        return adminUserMapper.getAdminUserVO(loginName);
    }


    @Override
    public List<Long> listUserRole(Long userId) {
        return adminUserRoleMapper.selectUserRoles(userId);
    }

    @Override
    public List<Long> listUserResc(Long userId) {
        return adminUserRoleMapper.selectUserResc(userId);
    }

}