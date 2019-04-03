package com.onemile.bms.service.admin;

import com.onemile.bms.entity.admin.AdminDept;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

/**
 * @author Eric
 */
public interface AdminDeptService extends BaseService<AdminDept> {

    /**
     * 查询部门list
     *
     * @param mchId    商户id
     * @param parentId 父id
     * @return
     */
    List<AdminDept> listDept(Long mchId, Integer parentId);

    /**
     * 创建组织机构
     *
     * @param adminDept
     * @return
     */
    Integer saveDept(AdminDept adminDept);

    /**
     * 删除组织机构
     *
     * @param id
     * @param parentId
     * @return
     */
    Integer deleteDept(Integer id, Integer parentId);

    /**
     * 验证名称是否重复
     *
     * @param mchId    商户id
     * @param deptName 名称
     * @param notInId  排除在外的id
     * @return
     */
    Boolean checkDeptName(Long mchId, String deptName, Integer notInId);

    /**
     * 查询当前节点下的所有子节点
     *
     * @param deptId
     * @return
     */
    List<Integer> listChilds(Integer deptId);

}