package com.onemile.bms.controller.admin;

import com.onemile.bms.constant.SystemConst;
import com.onemile.bms.controller.BaseController;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eric
 * @date 2018/9/14
 * @descripe 用于shiro 的操作接口
 */
@RestController
@RequestMapping(value = "/userApi", method = RequestMethod.POST)
public class AdminUserApiController extends BaseController {


    @Autowired
    private AdminUserService adminUserService;

    /**
     * 登录名接口
     *
     * @param loginName
     * @param key
     * @return
     */
    @RequestMapping("/getAdminUser")
    public AdminUserVO getAdminUser(String loginName, String key) {
        if (!key.equals(SystemConst.SHIRO_SECRET_KEY)) {
            return null;
        }

        return adminUserService.getAdminUserVO(loginName);
    }

    /**
     * 用户资源接口
     *
     * @param userId
     * @param key
     * @return
     */
    @RequestMapping("/listUserResc")
    public List<Long> listUserResc(Long userId, String key) {
        if (!key.equals(SystemConst.SHIRO_SECRET_KEY)) {
            return null;
        }
        return adminUserService.listUserResc(userId);
    }

    /**
     * 用户角色接口
     *
     * @param userId
     * @param key
     * @return
     */
    @RequestMapping("/listUserRole")
    public List<Long> listUserRole(Long userId, String key) {
        if (!key.equals(SystemConst.SHIRO_SECRET_KEY)) {
            return null;
        }
        return adminUserService.listUserRole(userId);
    }

}
