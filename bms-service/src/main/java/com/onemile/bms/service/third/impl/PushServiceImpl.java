package com.onemile.bms.service.third.impl;

import com.alibaba.fastjson.JSON;
import com.onemile.bms.result.AjaxResult;
import com.onemile.bms.service.third.PushService;
import com.onemile.bms.utils.DateUtil;
import com.onemile.bms.utils.HttpUtils;
import com.onemile.bms.utils.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @date 2018/9/5
 */
@Service
public class PushServiceImpl implements PushService {

    private Logger logger = LoggerFactory.getLogger(PushServiceImpl.class);

    @Value("${sms.pushAliasTempUrl}")
    private String aliasTempUrl;

    @Override
    public void pushAliasTemp(Integer tempId, String alias, String parmJson, String extrasJson) {
        //String appName, Integer tempId, String alias, String parmJson, String extrasJson
        try {
            Map<String, Object> map = new HashMap<>(2);
            map.put("appName", "ZXSHARE");
            map.put("tempId", tempId);
            map.put("alias", alias);
            map.put("parmJson", parmJson);
            map.put("extrasJson", extrasJson);
            map.put("requestTime", DateUtil.formateDate(new Date(), DateUtil.DATEFORMAT_STR_YMDHMS));

            String result = HttpUtils.send(aliasTempUrl, map);
            logger.debug("===== 调用推送结果：{}", result);
            if (ToolUtil.isNotEmpty(result)) {
                AjaxResult ajaxResult = JSON.parseObject(result, AjaxResult.class);
                if (!ajaxResult.isSuccess()) {
                    logger.error("===== 调用推送返回错误信息：{}", ajaxResult.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

}
