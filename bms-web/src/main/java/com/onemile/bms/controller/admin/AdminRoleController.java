package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminRole;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminRoleQuery;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminRoleService;
import com.onemile.bms.service.admin.AdminUserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/18
 */
@Controller
@RequestMapping("/admin")
public class AdminRoleController extends BaseController {

    @Autowired
    private AdminRoleService roleService;

    @Autowired
    private AdminUserRoleService userRoleService;

    /**
     * 角色管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/role")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_MGR)
    public String adminRole(Model model) {
        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.PERM_ROLE_ADD);
        permMap.put("update", PermResourceConst.PERM_ROLE_UPDATE);
        permMap.put("del", PermResourceConst.PERM_ROLE_MGR);
        permMap.put("resc", PermResourceConst.PERM_ROLE_RESC);
        model.addAllAttributes(permMap);

        return "admin/adminRole";
    }

    /**
     * 查询角色列表
     *
     * @param adminRoleQuery
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleList")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_MGR)
    public PageInfoRsp<AdminRole> getRoleList(AdminRoleQuery adminRoleQuery) {
        try {
            adminRoleQuery.setMchId(getMchId());
            PageInfoRsp<AdminRole> adminRolePageInfoRsp = roleService.listPageByMap(adminRoleQuery);
            return adminRolePageInfoRsp;
        } catch (Exception e) {
            logger.error("AdminRoleController.getRoleList 异常 ", e);
            return null;
        }
    }

    /**
     * 新增角色
     *
     * @param adminRole
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveRole")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_ADD)
    public AjaxResult saveRole(AdminRole adminRole) {

        try {
            Assert.hasText(adminRole.getName(), "角色名称不能为空");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }

        try {
            adminRole.setMchId(getMchId());
            adminRole.setGmtCreate(new Date());
            adminRole.setGmtModified(new Date());
            roleService.insertSelective(adminRole);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminRoleController.saveRole 异常 ", e);
            return AjaxResult.failed();
        }
    }

    /**
     * 更新角色
     *
     * @param adminRole
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateRole")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_UPDATE)
    public AjaxResult updateRole(AdminRole adminRole) {
        try {
            Assert.hasText(adminRole.getName(), "角色名称不能为空");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            adminRole.setMchId(getMchId());
            adminRole.setGmtModified(new Date());
            roleService.updateSelective(adminRole);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminRoleController.updateRole 异常 ", e);
            return AjaxResult.failed();

        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole")
    @RequiresPermissions(PermResourceConst.PERM_ROLE_DEL)
    public AjaxResult deleteRole(AdminRole adminRole) {
        try {
            Assert.notNull(adminRole.getId(), "id不能为空");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {

            //todo 验证 角色下是否还有用户
            Integer users = userRoleService.countByRoleId(adminRole.getId());
            if (users != null && users > 0) {
                return AjaxResult.failed("角色下拥有用户，不能删除！");
            }
            roleService.deleteById(adminRole.getId());
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminRoleController.deleteRole 异常 ", e);
            return AjaxResult.failed();

        }
    }

}