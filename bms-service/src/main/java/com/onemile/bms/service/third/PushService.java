package com.onemile.bms.service.third;

/**
 * @author Eric
 * @date 2018/9/5
 */
public interface PushService {

    /**
     * 推送模板
     *
     * @param tempId     模板id
     * @param alias      别名
     * @param parmJson   参数json串
     * @param extrasJson 自定义参数
     */
    void pushAliasTemp(Integer tempId, String alias, String parmJson, String extrasJson);

}
