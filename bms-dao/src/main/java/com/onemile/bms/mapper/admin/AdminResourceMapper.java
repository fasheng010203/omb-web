package com.onemile.bms.mapper.admin;

import com.onemile.bms.entity.admin.AdminResource;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.admin.AdminMenuVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 */
@Repository
public interface AdminResourceMapper extends BaseMapper<AdminResource> {

    /**
     * 查询资源列表
     *
     * @param type 资料类型
     * @param pid  父id
     * @return
     */
    List<AdminResource> listRecource(@Param("type") Integer type, @Param("pid") Long pid);

    /**
     * 统计code是否重复
     *
     * @param appId
     * @param code
     * @return
     */
    Integer countByCode(@Param("appId") Long appId, @Param("code") String code);

    /**
     * 获取最大id
     *
     * @param pid
     * @return
     */
    Long getMaxId(@Param("pid") Long pid);

    /**
     * 用户登录后，加载的左导航菜单
     *
     * @param userId
     * @param isSuper
     * @return
     */
    List<AdminMenuVO> selectUserRoleResource(@Param("userId") Long userId, @Param("isSuper") Integer isSuper);


    /**
     * count 子菜单的数量
     *
     * @param pid
     * @return
     */
    Integer countChildMenus(@Param("pid") Long pid);

    /**
     * 按pid 批量删除
     *
     * @param pid
     * @return
     */
    Integer deleteByPid(@Param("pid") Long pid);

}