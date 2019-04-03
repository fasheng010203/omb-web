package com.onemile.bms.service.admin.impl;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.admin.AdminDept;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.admin.AdminDeptMapper;
import com.onemile.bms.service.admin.AdminDeptService;
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
public class AdminDeptServiceImpl extends BaseServiceImpl<AdminDept> implements AdminDeptService {

    private Logger logger = LoggerFactory.getLogger(AdminDeptServiceImpl.class);
    @Autowired
    private AdminDeptMapper adminDeptMapper;

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    protected BaseMapper<AdminDept> getBaseMapper() {
        return adminDeptMapper;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<AdminDept> listDept(Long mchId, Integer parentId) {
        return adminDeptMapper.listDept(mchId, parentId);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    @Transactional(value = "txManagerBms", rollbackFor = Exception.class)
    public Integer saveDept(AdminDept adminDept) {

        Integer deptId = adminDeptMapper.insertSelective(adminDept);

        // 更新父节点的leaf状态为0
        AdminDept deptUp = new AdminDept();
        deptUp.setId(adminDept.getParentId());
        deptUp.setLeaf(0);
        deptUp.setGmtModified(new Date());
        adminDeptMapper.updateByPrimaryKeySelective(deptUp);

        return deptId;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    @Transactional(value = "txManagerBms", rollbackFor = Exception.class)
    public Integer deleteDept(Integer id, Integer parentId) {

        adminDeptMapper.deleteByPrimaryKey(id);

        List<AdminDept> depts = adminDeptMapper.listDept(null, parentId);
        if (depts == null || depts.size() <= 0) {
            // 更新父节点的leaf状态为1
            AdminDept deptUp = new AdminDept();
            deptUp.setId(parentId);
            deptUp.setLeaf(1);
            deptUp.setGmtModified(new Date());
            adminDeptMapper.updateByPrimaryKeySelective(deptUp);
        }

        return null;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public Boolean checkDeptName(Long mchId, String deptName, Integer notInId) {
        return adminDeptMapper.getDeptByName(mchId, deptName, notInId) == null ? false : true;
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public List<Integer> listChilds(Integer deptId) {
        //此处没有使用函数的方式，避免集群时函数不可用。 如果单机数据库，可以使用函数方式。
        // 查询到3层
        List<Integer> childList = new ArrayList<>();
        List<AdminDept> adminDepts = adminDeptMapper.listDept(null, deptId);
        for (AdminDept dept : adminDepts) {
            childList.add(dept.getId());
            List<AdminDept> adminDepts2 = adminDeptMapper.listDept(null, dept.getId());
            for (AdminDept dept2 : adminDepts2) {
                childList.add(dept2.getId());
                List<AdminDept> adminDepts3 = adminDeptMapper.listDept(null, dept2.getId());
                for (AdminDept dept3 : adminDepts3) {
                    childList.add(dept3.getId());
                }
            }
        }
        return childList;
    }


}