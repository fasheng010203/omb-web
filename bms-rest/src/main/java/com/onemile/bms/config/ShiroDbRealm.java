package com.onemile.bms.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Eric
 */
public class ShiroDbRealm extends AuthorizingRealm {


    private static final Logger LOG = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        LOG.info("Shiro开始登录认证");
        //  认证沿用老版本，此处不做验证用户处理。只初始化资源2
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        // 用户角色列表

        // 认证缓存信息
        return new SimpleAuthenticationInfo(null, null, getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        return info;
    }
}
