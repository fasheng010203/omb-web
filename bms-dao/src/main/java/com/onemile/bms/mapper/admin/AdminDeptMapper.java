package com.onemile.bms.mapper.admin;

import com.onemile.bms.entity.admin.AdminDept;
import com.onemile.bms.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 */
@Repository
public interface AdminDeptMapper extends BaseMapper<AdminDept> {

    /**
     * 查询部门list
     *
     * @param mchId    商户id
     * @param parentId 父id
     * @return
     */
    List<AdminDept> listDept(@Param("mchId") Long mchId, @Param("parentId") Integer parentId);

    /**
     * 按商户部门名称查询
     *
     * @param mchId    商户id
     * @param deptName 名称
     * @return
     */
    AdminDept getDeptByName(@Param("mchId") Long mchId, @Param("deptName") String deptName, @Param("notInId") Integer notInId);
}