package com.onemile.bms.constant;

/**
 * @author ericma
 */
public interface PermResourceConst {

    /*角色管理*/
    String PERM_ROLE_MGR = "10201";

    /*新增角色*/
    String PERM_ROLE_ADD = "1020101";

    /*修改角色*/
    String PERM_ROLE_UPDATE = "1020102";

    /*删除角色*/
    String PERM_ROLE_DEL = "1020103";

    /*分配权限资源*/
    String PERM_ROLE_RESC = "1020104";

    /*用户管理*/
    String PERM_USER_MGR = "10202";

    /*新增用户*/
    String PERM_USER_ADD = "1020201";

    /*修改用户*/
    String PERM_USER_UPDATE = "1020202";

    /* 删除用户 */
    String PERM_USER_DELETE = "1020203";

    /*启用/解锁*/
    String PERM_USER_ENABLE = "1020204";

    /*锁定用户*/
    String PERM_USER_LOCK = "1020205";

    /*禁用用户*/
    String PERM_USER_DISABLE = "1020206";

    /*密码重置*/
    String PERM_USER_RESETPWD = "1020207";

    /*赋权（角色）*/
    String PERM_USER_ROLE = "1020206";

    /*资源管理*/
    String PERM_RESC_MGR = "10203";

    /*新增菜单*/
    String PERM_RESC_ADD = "1020301";

    /*修改菜单*/
    String PERM_RESC_UPDATE = "1020302";

    /*删除菜单*/
    String PERM_RESC_DEL = "1020304";


    /*位置管理*/
    String DEVICE_LOCMGR = "10403";
    /*事件管理*/
    String DEVICE_EVENTMGR = "10405";
    /*设备监控*/
    String ISSUE_MANAGEMENT = "10402";


    /*机构管理*/
    String PERM_ORG_MGR = "10204";

    /*新增机构*/
    String PERM_ORG_ADD = "1020401";

    /*修改机构*/
    String PERM_ORG_UPDATE = "1020402";

    /*删除机构*/
    String PERM_ORG_DEL = "1020403";




    /*会员列表*/
    String COMPANY_INFO_MGR="1040301";

    /*会员删除*/
    String COMPANY_INFO_DELETE="104030101";

    /*会员锁定*/
    String COMPANY_INFO_LOCK="104030102";

    /*会员解锁*/
    String COMPANY_INFO_UNLOCK="104030103";

    /*认证审核*/
    String COMPANY_AUTHENTICATION_MGR="1040302";

    /*认证审核 审核*/
    String COMPANY_AUTHENTICATION_CKECK="104030201";

    /*银行卡验证管理*/
    String COMPANY_BANKCARD_MGR="1040303";

    /*银行卡验证管理	打款*/
    String COMPANY_BANKCARD_ADD="104030301";

    /*提现申请*/
    String COMPANY_WITHDRAWCASH_MGR="1040304";

    /*提现	打款*/
    String COMPANY_WITHDRAWCASH_ADD="104030401";

    /*已经反馈*/
    String COMPANY_SUGGESTIONS_MGR="1040305";



    /*** 设备管理 ***/
    String DEVICE_MANAGEMENT = "10404";

    String DEVICE_MGR_ADD	 = "1040401";
    String DEVICE_MGR_CMD = "1040402";

    /*** 设备出入库管理 ***/
    String DEVICE_INANDOUT = "10406";

    String DEVICE_INANDOUT_UPDATE	 = "1040601";




    /*物资规格维护*/
    String GOODS_SPEC_MGR =  "1040501";

    /*物资规格维护新增*/
    String GOODS_SPEC_ADD = "104050201";

    /*物资规格维护修改*/
    String GOODS_SPEC_UPDATE = "104050202";

    /*物资规格维护删除*/
    String GOODS_SPEC_DEL = "104050203";


    /*	销售的品质规格维护*/
    String GOODS_QUALITY_SPEC_MGR =  "1040504";

    /*	销售的品质规格新增*/
    String GOODS_QUALITY_SPEC_ADD = "104050401";

    /*	销售的品质规格修改*/
    String GOODS_QUALITY_SPEC_UPDATE = "104050402";

    /*	销售的品质规格删除*/
    String GOODS_QUALITY_SPEC_DEL = "104050403";

    /*APP版本管理*/
    String APP_VERSION_MGR =  "1040503";

    /*APP版本新增*/
    String APP_VERSION_ADD = "104050301";

    /*APP版本修改*/
    String APP_VERSIONT_UPDATE = "104050302";
}
