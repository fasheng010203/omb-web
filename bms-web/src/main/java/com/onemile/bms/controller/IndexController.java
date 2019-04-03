package com.onemile.bms.controller;

import com.onemile.bms.constant.PermRoleConst;
import com.onemile.bms.constant.RedisKey;
import com.onemile.bms.entity.admin.AdminCity;
import com.onemile.bms.pojo.vo.admin.AdminMenuVO;
import com.onemile.bms.service.admin.AdminCityService;
import com.onemile.bms.service.admin.AdminResourceService;
import com.onemile.bms.utils.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric
 * @Description:
 * @date 2018/5/24
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private AdminResourceService resourceService;

    @Autowired
    private AdminCityService adminCityService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        AdminCity adminCity=new AdminCity();
        adminCity.setUserid(getUserId());
        List<AdminCity> listAdminCity=adminCityService.listAdminCityByUserId(adminCity);

        String sfiter="";

        for (int i=0 ;i<listAdminCity.size();i++)
        {
            sfiter=sfiter+listAdminCity.get(i).getUsercity()+",";
        }

        if (sfiter.length()>0)
        {
            sfiter=sfiter.substring(0,sfiter.length()-1);
        }

        RedisUtil.set(RedisKey.USER_ADMIN_CITY+getUserId().toString(),sfiter,3600);

        logger.info(sfiter);



        model.addAttribute("userName", getLoginName());
        model.addAttribute("realName", getUserRealName());



        return "index";
    }

    /**
     * 获取用户菜单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getMenuList")
    public List<AdminMenuVO> getMenuList() {

        // 是否是超级管理员角色
        Boolean isSuperAdmin = SecurityUtils.getSubject().hasRole(PermRoleConst.SUPERADMIN);

        Boolean isAdmin = SecurityUtils.getSubject().hasRole(PermRoleConst.ADMIN);

        List<AdminMenuVO> adminMenuVOList;
        if (isSuperAdmin) {
            //超级管理员查询所有菜单
            adminMenuVOList = resourceService.listUserMenuResc(null, null);
        } else {
            if (isAdmin) {
                //管理员查询 is_super=0 的非超级管理的菜单
                adminMenuVOList = resourceService.listUserMenuResc(null, 0);
            } else {
                //普通用户按角色配置查询
                adminMenuVOList = resourceService.listUserMenuResc(getUserId(), 0);
            }
        }

        List<AdminMenuVO> newMenVOList = getChildrenNode(1L, adminMenuVOList);

        return newMenVOList;
    }


    /**
     * AdminMenuVO 的子节点
     *
     * @param
     * @param
     * @return
     */
    private List<AdminMenuVO> getChildrenNode(Long pid, List<AdminMenuVO> adminMenuVOList) {
        List<AdminMenuVO> newAdminMenuVoList = new ArrayList<>();
        for (AdminMenuVO adminMenuVO : adminMenuVOList) {
            if (adminMenuVO.getId() == 1) {
                continue;
            }
            // 这是一个子节点
            if (adminMenuVO.getPid().equals(pid)) {
                // 递归获取子节点下的子节点
                List<AdminMenuVO> childList = getChildrenNode(adminMenuVO.getId(), adminMenuVOList);
                if (childList.size() > 0) {
                    adminMenuVO.setMenus(childList);
                }
                newAdminMenuVoList.add(adminMenuVO);
            }
        }
        return newAdminMenuVoList;
    }


}
