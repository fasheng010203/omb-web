package com.onemile.bms.config.shiro;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.onemile.bms.constant.PermRoleConst;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.shiro.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @author Eric
 */
public class ShiroWebDbRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroWebDbRealm.class);

    @Autowired
    private ShiroService shiroService;

    @Override
    @SwitchDs(ms= DbMsEnum.BMS)
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        logger.info("============= {} 登录认证 =============", token.getUsername());

        AdminUserVO adminUser = shiroService.getAdminUserVO(token.getUsername());

        // 账号不存在
        if (adminUser == null) {
            throw new UnknownAccountException();
        }
        // 账号非法状态
        if (adminUser.getStatus() != 1) {
            throw new DisabledAccountException();
        }

        // 查询角色
        List<Long> roles = shiroService.listUserRole(adminUser.getId());

        // 账号未分配角色
        if (roles == null) {
            logger.warn("============= 用户:{} 未赋权  =============", adminUser.getLoginName());
        }

        // 用户角色列表
        ShiroWebUser shiroWebUser = new ShiroWebUser(adminUser.getId(), adminUser.getMchId(), adminUser.getDeptId(), adminUser.getLoginName(), adminUser.getRealName(),adminUser.getMchName(), roles, null);

        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroWebUser, adminUser.getLoginPwd().toCharArray(), getName());

    }


    @Override
    @SwitchDs(ms= DbMsEnum.BMS)
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        boolean hasAdminRole = false;

        ShiroWebUser webUser = (ShiroWebUser) SecurityUtils.getSubject().getPrincipal();

        List<Long> roleList = webUser.getRoleList();

        if (roleList != null) {
            info.addRoles(Lists.transform(roleList, new Function<Long, String>() {
                @Override
                public String apply(Long input) {
                    return input.toString();
                }
            }));

            //超级管理员拥有全部admin_resource.is_super=1 的菜单权限
            if (roleList.contains(Long.valueOf(PermRoleConst.SUPERADMIN))) {
                hasAdminRole = true;
            }
            //普通管理员拥有全部admin_resource.is_super=0 的菜单权限
            if (roleList.contains(Long.valueOf(PermRoleConst.ADMIN))) {
                hasAdminRole = true;
            }
        }

        List<Long> rescIds = shiroService.listUserResc(webUser.getId());

        Set<String> resourceSet = null;
        if (hasAdminRole) {
            resourceSet = Sets.newHashSetWithExpectedSize(1);
            //如果是管理员则拥有所有权限
            resourceSet.add("*");
        } else if (rescIds != null) {
            resourceSet = Sets.newHashSetWithExpectedSize(rescIds.size());
            for (Long rescId : rescIds) {
                resourceSet.add(rescId.toString());
            }
        }

        info.addStringPermissions(resourceSet);

        return info;
    }
}
