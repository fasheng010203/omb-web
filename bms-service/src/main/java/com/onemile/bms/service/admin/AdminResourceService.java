package com.onemile.bms.service.admin;

import com.onemile.bms.entity.admin.AdminResource;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.vo.admin.AdminMenuVO;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

/**
 * @author Eric
 */
public interface AdminResourceService extends BaseService<AdminResource> {

    /**
     * 查询资源
     *
     * @param type 资源类型 1-菜单 2-操作按钮
     * @param pid  父id
     * @return
     */
    List<AdminResource> listRecource(Integer type, Long pid);


    /**
     * 查询子资源列表
     *
     * @param pid 父id
     * @return
     */
    PageInfoRsp<AdminResource> listPageByMap(Long pid);


    /**
     * @param appId
     * @param code
     * @return
     */
    Boolean checkCode(Long appId, String code);

    /**
     * 查询 子节点最大id
     *
     * @param pid
     * @return
     */
    Long getMaxId(Long pid);


    /**
     * 查询用户菜单资源
     *
     * @param userId
     * @param isSuper
     * @return
     */
    List<AdminMenuVO> listUserMenuResc(Long userId, Integer isSuper);

    /**
     * count 子菜单的数量
     *
     * @param pid
     * @return
     */
    Integer countChildMenus(Long pid);

    /**
     *
     * @param id
     * @param actionIds
     * @return
     */
    void deleteResource(Long id,List<Long> actionIds);
}