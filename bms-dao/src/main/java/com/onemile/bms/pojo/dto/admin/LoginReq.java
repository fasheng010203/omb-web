package com.onemile.bms.pojo.dto.admin;

/**
 * @author Eric
 * @Description:
 * @date 2018/6/8
 */
public class LoginReq {

    private String loginName;
    private String password;
    private String checkCode;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
