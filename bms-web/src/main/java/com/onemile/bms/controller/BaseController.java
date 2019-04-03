package com.onemile.bms.controller;

import com.google.common.collect.Lists;
import com.onemile.bms.config.shiro.ShiroWebUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Eric
 * @description：基础 controller
 */
public abstract class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前登录用户对象
     *
     * @return
     */
    public ShiroWebUser getCurrentUser() {
        ShiroWebUser user = (ShiroWebUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

    /**
     * 获取当前登录用户id
     *
     * @return
     */
    public Long getUserId() {
        return this.getCurrentUser().getId();
    }

    /**
     * 获取当前用户所属商户id
     *
     * @return
     */
    public Long getMchId() {
        return this.getCurrentUser().getMchId();
    }

    /**
     * 获取当前登录用户名
     *
     * @return
     */
    public String getLoginName() {
        return this.getCurrentUser().getLoginName();
    }

    public String getUserRealName() {
        return this.getCurrentUser().getRealName();
    }

    public boolean hasAnyRoles(String... roles) {
        Subject subject = SecurityUtils.getSubject();
        List<String> roleList = Lists.newArrayList(roles);
        boolean[] hasRoles = subject.hasRoles(roleList);
        for (boolean hasRole : hasRoles) {
            if (hasRole) {
                return true;
            }
        }
        return false;
    }
}
