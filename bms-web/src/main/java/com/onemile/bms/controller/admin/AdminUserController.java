package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.PermResourceConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.entity.admin.AdminUser;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.admin.AdminUserQuery;
import com.onemile.bms.pojo.dto.admin.AdminUserReq;
import com.onemile.bms.pojo.dto.admin.AdminUserRoleReq;
import com.onemile.bms.pojo.vo.admin.AdminUserRoleVO;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.admin.AdminUserRoleService;
import com.onemile.bms.service.admin.AdminUserService;
import com.onemile.bms.utils.MD5Util;
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
 * @date 2018/6/11
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AdminUserRoleService userRoleService;

    /**
     * 用户管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/user")
    @RequiresPermissions(PermResourceConst.PERM_USER_MGR)
    public String adminUser(Model model) {

        Map<String, Object> permMap = new HashMap<String, Object>(5);
        permMap.put("add", PermResourceConst.PERM_USER_ADD);
        permMap.put("update", PermResourceConst.PERM_USER_UPDATE);
        permMap.put("del", PermResourceConst.PERM_USER_DELETE);
        permMap.put("lock", PermResourceConst.PERM_USER_DISABLE);
        permMap.put("unlock", PermResourceConst.PERM_USER_ENABLE);
        permMap.put("role", PermResourceConst.PERM_USER_ROLE);
        model.addAllAttributes(permMap);

        return "admin/adminUser";
    }

    /**
     * 获取用户列表数据
     *
     * @param adminUserQuery
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserList")
    @RequiresPermissions(PermResourceConst.PERM_USER_MGR)
    public PageInfoRsp<AdminUserVO> getUserList(AdminUserQuery adminUserQuery) {
        try {
            adminUserQuery.setMchId(getMchId());
            PageInfoRsp<AdminUserVO> adminUserPageInfoRsp = adminUserService.listPageByMap(adminUserQuery);
            return adminUserPageInfoRsp;
        } catch (Exception e) {
            logger.error("AdminUserController异常 ", e);
            return null;
        }
    }

    /**
     * 保存用户
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveUser")
    @RequiresPermissions(PermResourceConst.PERM_USER_ADD)
    public AjaxResult saveUser(AdminUserReq adminUserReq) {
        try {
            Assert.hasText(adminUserReq.getLoginName(), "登录名称不能为空！");
            Assert.hasText(adminUserReq.getRealName(), "真实姓名不能为空！");
            Assert.hasText(adminUserReq.getPassword(), "密码不能为空！");
            Assert.notNull(adminUserReq.getDeptId(), "所属部门不能为空！");
            Assert.notNull(adminUserReq.getSex(), "性别不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            AdminUser adminUser = adminUserService.getByLoginName(adminUserReq.getLoginName());
            if (adminUser != null) {
                return AjaxResult.failed("登录名称重复");
            }
            Date now = new Date();
            adminUser = new AdminUser();
            adminUser.setMchId(getMchId());
            adminUser.setLoginName(adminUserReq.getLoginName());
            adminUser.setRealName(adminUserReq.getRealName());
            adminUser.setLoginPwd(MD5Util.encrypt(adminUserReq.getPassword()));
            adminUser.setDeptId(adminUserReq.getDeptId());
            adminUser.setSex(adminUserReq.getSex());
            adminUser.setMobile(adminUserReq.getMobile());
            adminUser.setGmtCreate(now);
            adminUser.setGmtModified(now);
            adminUserService.insertSelective(adminUser);
            return AjaxResult.success();

        } catch (Exception e) {
            logger.error("AdminUserController.saveUser 出现异常 ", e);
            return AjaxResult.failed("服务器处理异常");
        }

    }

    /**
     * 修改用户
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser")
    @RequiresPermissions(PermResourceConst.PERM_USER_UPDATE)
    public AjaxResult updateUser(AdminUserReq adminUserReq) {
        try {
            Assert.hasText(adminUserReq.getLoginName(), "登录名称不能为空！");
            Assert.hasText(adminUserReq.getRealName(), "真实姓名不能为空！");
            Assert.notNull(adminUserReq.getDeptId(), "所属部门不能为空！");
            Assert.notNull(adminUserReq.getSex(), "性别不能为空！");
            Assert.notNull(adminUserReq.getUserId(), "id不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(adminUserReq.getUserId());
            adminUser.setRealName(adminUserReq.getRealName());
            if (StringUtils.hasText(adminUserReq.getPassword())) {
                adminUser.setLoginPwd(MD5Util.encrypt(adminUserReq.getPassword()));
            }
            adminUser.setDeptId(adminUserReq.getDeptId());
            adminUser.setSex(adminUserReq.getSex());
            adminUser.setMobile(adminUserReq.getMobile());
            adminUser.setGmtModified(new Date());
            adminUserService.updateSelective(adminUser);
            return AjaxResult.success();

        } catch (Exception e) {
            logger.error("AdminUserController.updateUser 出现异常：", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

    /**
     * deleteUser
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUser")
    @RequiresPermissions(PermResourceConst.PERM_USER_DELETE)
    public AjaxResult deleteUser(AdminUserReq adminUserReq) {
        try {
            Assert.notNull(adminUserReq.getUserId(), "id不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(adminUserReq.getUserId());
            adminUser.setIsDelete(1);
            adminUser.setGmtModified(new Date());
            adminUserService.updateSelective(adminUser);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminUserController.deleteUser 出现异常：", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

    /**
     * lockUser
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lockUser")
    @RequiresPermissions(PermResourceConst.PERM_USER_DISABLE)
    public AjaxResult lockUser(AdminUserReq adminUserReq) {
        try {
            Assert.notNull(adminUserReq.getUserId(), "id不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(adminUserReq.getUserId());
            adminUser.setStatus(adminUserReq.getStatus());
            adminUser.setGmtModified(new Date());
            adminUserService.updateSelective(adminUser);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminUserController.lockUser 出现异常：", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

    /**
     * 获取用户分配的角色列表
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserRoleList")
    @RequiresPermissions(PermResourceConst.PERM_USER_MGR)
    public List<AdminUserRoleVO> getUserRoleList(AdminUserReq adminUserReq) {
        try {
            return adminUserService.listUserRole(adminUserReq.getUserId(), getMchId());
        } catch (Exception e) {
            logger.error("AdminUserController.getUserRoleList 出现异常：", e);
            return null;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/saveUserRoles")
    @RequiresPermissions(PermResourceConst.PERM_USER_MGR)
    public AjaxResult saveUserRoles(AdminUserRoleReq adminUserRoleReq) {

        try {
            Assert.notNull(adminUserRoleReq.getUserId(), "用户不能为空！");
            Assert.hasText(adminUserRoleReq.getRoleIds(), "角色不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }

        try {
            String[] sroles = adminUserRoleReq.getRoleIds().split(",");
            List<Long> roles = new ArrayList<>();
            for (int i = 0; i < sroles.length; i++) {
                roles.add(Long.parseLong(sroles[i]));
            }
            userRoleService.insertUserRoles(adminUserRoleReq.getUserId(), roles, getMchId());

            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("AdminUserController.saveUserRoles 出现异常：", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }




    /**
     * 修改密码
     *
     * @param adminUserReq
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePwd")
    @RequiresPermissions(PermResourceConst.PERM_USER_UPDATE)
    public AjaxResult updatePwd(AdminUserReq adminUserReq) {
        try {
            Assert.hasText(adminUserReq.getLoginPwd(), "新密码不能为空！");
            Assert.hasText(adminUserReq.getOldLoginPwd(), "原密码不能为空！");
        } catch (Exception e) {
            return AjaxResult.failed(e.getMessage());
        }
        try {

            String oldLoginPwd="";

            if (StringUtils.hasText(adminUserReq.getOldLoginPwd())) {
                oldLoginPwd=MD5Util.encrypt(adminUserReq.getOldLoginPwd());
            }
            AdminUser adminUser= adminUserService.selectUserByPwd(getUserId(),oldLoginPwd,getMchId());
            if(adminUser==null){
                return  AjaxResult.failed("原密码错误");
            }else{
                adminUser.setLoginPwd(MD5Util.encrypt(adminUserReq.getLoginPwd()));
            }
            adminUserService.updateSelective(adminUser);
            return AjaxResult.success();

        } catch (Exception e) {
            logger.error("AdminUserController.updatePwd 出现异常：", e);
            return AjaxResult.failed("服务器处理异常");
        }
    }

}
