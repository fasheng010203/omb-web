package com.onemile.bms.controller;

import com.onemile.bms.pojo.dto.admin.LoginReq;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Eric
 * @Description:
 * @date 2018/6/8
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录View
     */
    @RequestMapping(value = "/login")
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value = "/loginDo")
    @ResponseBody
    public AjaxResult loginDo(LoginReq loginReq) {

        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getLoginName(), MD5Util.encrypt(loginReq.getPassword()));

        AjaxResult ajaxResult = null;

        try {
            user.login(token);
            ajaxResult = AjaxResult.success();
        } catch (UnknownAccountException e) {
            token.clear();
            ajaxResult = AjaxResult.failed("账号不存在");
        } catch (DisabledAccountException e) {
            token.clear();
            ajaxResult = AjaxResult.failed("账号未启用");
        } catch (IncorrectCredentialsException e) {
            token.clear();
            ajaxResult = AjaxResult.failed("密码错误");
        } catch (RuntimeException e) {
            token.clear();
            ajaxResult = AjaxResult.failed("未知错误,请联系管理员");
        }

        return ajaxResult;
    }


}
