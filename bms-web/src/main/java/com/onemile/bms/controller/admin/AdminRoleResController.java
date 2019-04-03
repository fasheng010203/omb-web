package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminRoleResource;
import com.onemile.bms.entity.easyuitree.EasyUITreeNew;
import com.onemile.bms.pojo.vo.admin.AdminRoleRescVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminRoleResourceService;
import com.onemile.bms.utils.EasyuiUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
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
public class AdminRoleResController extends BaseController {

    @Autowired
    private AdminRoleResourceService roleResourceService;

    /**
     * 页面视图
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/roleRescource")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_RESC)
    public String adminUser(Model model, String roleId) {

        Map<String, Object> permMap = new HashMap<>(1);
        model.addAllAttributes(permMap);
        model.addAttribute("roleId", roleId);
        return "admin/roleResource";
    }

    /**
     * 查询角色的菜单资源信息 type=1
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleRescList")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_RESC)
    public List<EasyUITreeNew> getRoleRescList(String roleId) {
        try {
            if (!StringUtils.hasText(roleId)) {
                return null;
            }
            List<AdminRoleRescVO> roleRescVOList = roleResourceService.listRoleResc(Long.parseLong(roleId));
            if (roleRescVOList == null) {
                return null;
            }

            List<EasyUITreeNew> easyUITreeNews = new ArrayList<EasyUITreeNew>();

            for (AdminRoleRescVO adminRoleRescVO : roleRescVOList) {

                EasyUITreeNew treeData = new EasyUITreeNew();
                treeData.setId(adminRoleRescVO.getId() + "");
                treeData.setText(adminRoleRescVO.getName());
                treeData.setState("open");
                if ("1".equals(adminRoleRescVO.getChecked())) {
                    treeData.setChecked(true);
                } else {
                    treeData.setChecked(false);
                }

                Map<String, Object> map = new HashMap<>(1);
                map.put("layer", adminRoleRescVO.getLayer());
                treeData.setPid(adminRoleRescVO.getPid() + "");
                treeData.setAttributes(map);
                easyUITreeNews.add(treeData);
            }

            List<EasyUITreeNew> treeList = EasyuiUtil.getfatherNode("0", easyUITreeNews);

            return treeList;

        } catch (Exception e) {
            logger.error("AdminRoleResController.getRoleRescList 异常", e);
            return null;
        }
    }

    /**
     * 查询选中的菜单拥有的操作按钮资源
     *
     * @param roleId
     * @param pids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleRescListByPids")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_RESC)
    public List<AdminRoleRescVO> getRoleRescListByPids(String roleId, String pids) {
        try {
            if (!StringUtils.hasText(roleId) || !StringUtils.hasText(pids)) {
                return null;
            }

            String[] idArray = pids.split(",");
            List<Long> pidList = new ArrayList<Long>();
            for (String id : idArray) {
                pidList.add(Long.parseLong(id));
            }

            return roleResourceService.listRoleRescByPids(pidList, Long.parseLong(roleId));


        } catch (Exception e) {
            logger.error("AdminRoleResController.getRoleRescList 异常", e);
            return null;
        }
    }

    /**
     * 保存角色的资源权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveRoleRescource")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_RESC)
    public AjaxResult saveRoleRescource(String resourceIds, String roleId) {
        try {
            Assert.hasText(resourceIds, "请选择资源");
            Assert.hasText(roleId, "角色id不存在");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            List<AdminRoleResource> roleResList = new ArrayList<>();
            String[] idArray = resourceIds.split(",");
            for (int i = 0; i < idArray.length; i++) {
                AdminRoleResource roleRes = new AdminRoleResource();
                roleRes.setRoleId(Long.parseLong(roleId + ""));
                roleRes.setResourceId(Long.parseLong(idArray[i]));
                roleRes.setType(2);
                roleRes.setGmtCreate(new Date());
                roleRes.setGmtModified(new Date());
                roleResList.add(roleRes);
            }

            roleResourceService.saveBatch(roleResList, Long.parseLong(roleId));

            return AjaxResult.success();
        } catch (NumberFormatException e) {
            logger.error("AdminRoleResController.saveRoleRescource NumberFormat异常:{}", e.getMessage());
            return AjaxResult.failed("类型转换异常");
        } catch (Exception e) {
            logger.error("AdminRoleResController.saveRoleRescource NumberFormat异常:{}", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }


}
