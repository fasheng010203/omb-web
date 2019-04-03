package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminResource;
import com.onemile.bms.entity.easyuitree.EasyUITreeNew;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminResourceReq;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminResourceService;
import com.onemile.bms.utils.EasyuiUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author Eric
 * @Description:
 * @date 2018/6/26
 */
@Controller
@RequestMapping("/admin")
public class AdminResourceController extends BaseController {


    @Autowired
    private AdminResourceService resourceService;

    /**
     * 菜单资源管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/resource")
    @RequiresPermissions(PermResourceConst.PERM_RESC_MGR)
    public String adminResource(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.PERM_RESC_ADD);
        permMap.put("update", PermResourceConst.PERM_RESC_UPDATE);
        permMap.put("del", PermResourceConst.PERM_RESC_DEL);
        model.addAllAttributes(permMap);

        return "admin/resource";
    }


    /**
     * 获取菜单的资源列表¬
     *
     * @param pid 父id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRescourceList")
    @RequiresPermissions(PermResourceConst.PERM_RESC_MGR)
    public PageInfoRsp<AdminResource> getRescourceList(Long pid) {
        try {
            if (pid == null) {
                pid = 99999999L;
            }
            PageInfoRsp<AdminResource> adminResourcePageInfoRsp = resourceService.listPageByMap(pid);
            return adminResourcePageInfoRsp;
        } catch (Exception e) {
            logger.error("AdminUserController异常 ", e);
            return null;
        }
    }


    /**
     * 获取easyui tree 的数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRecTreeList")
    @RequiresPermissions(PermResourceConst.PERM_RESC_MGR)
    public List<EasyUITreeNew> getListForEasyUI() {
        List<EasyUITreeNew> treeDataList = new ArrayList<>();
        // 查询菜单
        List<AdminResource> dataList = resourceService.listRecource(1, null);
        for (AdminResource resource : dataList) {
            EasyUITreeNew tree = new EasyUITreeNew();
            if (resource.getLayer() <= 3) {
                tree.setState("open");
            } else {
                tree.setState("close");
            }
            tree.setId(resource.getId() + "");
            tree.setText(resource.getName());
            tree.setPid(resource.getPid() + "");

            Map<String, Object> maps = new HashMap<>(7);
            maps.put("code", resource.getCode());
            maps.put("menuLeafFlag", resource.getCode());
            maps.put("menuLeafUrl", resource.getMenuLeafUrl());
            maps.put("menuLeafMode", resource.getMenuLeafMode());
            maps.put("layer", resource.getLayer());
            maps.put("orderNo", resource.getOrderNo());
            maps.put("remark", resource.getRemark());
            tree.setAttributes(maps);
            treeDataList.add(tree);

        }

        List<EasyUITreeNew> treeList = EasyuiUtil.getfatherNode("0", treeDataList);

        return treeList;
    }

    @ResponseBody
    @RequestMapping(value = "/getRecMaxId")
    @RequiresPermissions(PermResourceConst.PERM_RESC_MGR)
    public AjaxResult getRecMaxId(Long pid) {
        try {
            Long maxId = resourceService.getMaxId(pid);
            return AjaxResult.success(maxId);
        } catch (Exception e) {
            logger.error("AdminResourceController.getRecMaxId 异常", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

    /**
     * 新增资源
     *
     * @param resourceReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveResource")
    @RequiresPermissions(PermResourceConst.PERM_RESC_ADD)
    public AjaxResult saveResource(AdminResourceReq resourceReq) {
        try {
            Assert.hasText(resourceReq.getCode(), "资源编码不能为空！");
            Assert.hasText(resourceReq.getName(), "资源名称不能为空！");
            Assert.notNull(resourceReq.getId(), "资源编号不能为空！");
            Assert.notNull(resourceReq.getOrderNo(), "显示排序不能为空！");
            Assert.notNull(resourceReq.getPid(), "所属资源不能为空！");
            Assert.notNull(resourceReq.getType(), "资源类型不能为空！");
            Assert.notNull(resourceReq.getMenuLeafFlag(), "是否是叶子菜单不能为空！");
            Assert.notNull(resourceReq.getIsSuper(), "是否是超级菜单不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            Date now = new Date();
            AdminResource adminResource = new AdminResource();

            adminResource.setId(resourceReq.getId());
            adminResource.setPid(resourceReq.getPid());
            adminResource.setAppId(1L);
            adminResource.setType(resourceReq.getType());
            adminResource.setCode(resourceReq.getCode());
            adminResource.setName(resourceReq.getName());
            adminResource.setLayer(resourceReq.getLayer());
            adminResource.setMenuLeafFlag(resourceReq.getMenuLeafFlag());
            adminResource.setMenuLeafUrl(resourceReq.getMenuLeafUrl());
            adminResource.setMenuLeafMode(1);
            adminResource.setOrderNo(resourceReq.getOrderNo());
            adminResource.setIcon(resourceReq.getIcon());
            adminResource.setIsSuper(resourceReq.getIsSuper());
            adminResource.setGmtCreate(now);
            adminResource.setGmtModified(now);

            resourceService.insertSelective(adminResource);

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminResourceController.saveResource 异常", e);
            return AjaxResult.failed("服务器处理异常");
        }

    }

    /**
     * 修改资源
     *
     * @param resourceReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateResource")
    @RequiresPermissions(PermResourceConst.PERM_RESC_UPDATE)
    public AjaxResult updateResource(AdminResourceReq resourceReq) {
        try {
            Assert.hasText(resourceReq.getName(), "资源名称不能为空！");
            Assert.notNull(resourceReq.getOrderNo(), "显示排序不能为空！");
            Assert.notNull(resourceReq.getPid(), "所属资源不能为空！");
            Assert.notNull(resourceReq.getType(), "资源类型不能为空！");
            Assert.notNull(resourceReq.getMenuLeafFlag(), "是否是叶子菜单不能为空！");
            Assert.notNull(resourceReq.getIsSuper(), "是否是超级菜单不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            AdminResource adminResource = new AdminResource();
            adminResource.setId(resourceReq.getId());
            adminResource.setType(resourceReq.getType());
            adminResource.setName(resourceReq.getName());
            adminResource.setMenuLeafFlag(resourceReq.getMenuLeafFlag());
            adminResource.setMenuLeafUrl(resourceReq.getMenuLeafUrl());
            adminResource.setOrderNo(resourceReq.getOrderNo());
            adminResource.setIcon(resourceReq.getIcon());
            adminResource.setIsSuper(resourceReq.getIsSuper());
            adminResource.setGmtModified(new Date());
            resourceService.updateSelective(adminResource);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminResourceController.updateResource 异常", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

    /**
     * 删除资源
     *
     * @param resourceReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deteleResource")
    @RequiresPermissions(PermResourceConst.PERM_RESC_DEL)
    public AjaxResult deteleResource(AdminResourceReq resourceReq) {

        try {
            if (resourceService.countChildMenus(resourceReq.getId()) > 0) {
                return AjaxResult.failed("不能删除包含子菜单的菜单");
            }

            List<AdminResource> resourceList = resourceService.listRecource(null, resourceReq.getId());
            List<Long> actionIds = new ArrayList<>();
            for (AdminResource adminResource : resourceList) {
                actionIds.add(adminResource.getId());
            }
            resourceService.deleteResource(resourceReq.getId(), actionIds);

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminResourceController.deteleResource 异常", e);
            return AjaxResult.failed("服务器处理异常");
        }

    }

}
