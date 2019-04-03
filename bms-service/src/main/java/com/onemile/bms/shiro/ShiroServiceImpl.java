package com.onemile.bms.shiro;

import com.alibaba.fastjson.JSON;
import com.onemile.bms.constant.SystemConst;
import com.onemile.bms.pojo.vo.admin.AdminUserVO;
import com.onemile.bms.utils.HttpUtils;
import com.onemile.bms.utils.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eric
 * @Description:
 * @date 2018/7/11
 */
@Service
public class ShiroServiceImpl implements ShiroService {


    private static final Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    @Value("${server.port}")
    private Integer port;

    @Override
    public AdminUserVO getAdminUserVO(String loginName) {

        String url = "http://localhost:" + port + "/userApi/getAdminUser";
        Map<String, Object> map = new HashMap<>(1);
        map.put("loginName", loginName);
        map.put("key", SystemConst.SHIRO_SECRET_KEY);

        String result = HttpUtils.send(url, map);

        if (ToolUtil.isNotEmpty(result)) {
            AdminUserVO adminUserVO = JSON.parseObject(result, AdminUserVO.class);
            return adminUserVO;
        } else {
            return null;
        }

    }

    @Override
    public List<Long> listUserRole(Long userId) {
        String url = "http://localhost:" + port + "/userApi/listUserRole";
        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", userId);
        map.put("key", SystemConst.SHIRO_SECRET_KEY);

        String result = HttpUtils.send(url, map);

        if (ToolUtil.isNotEmpty(result)) {
            List<Long> roleList = JSON.parseArray(result, Long.class);
            return roleList;
        } else {
            return null;
        }
    }

    @Override
    public List<Long> listUserResc(Long userId) {
        String url = "http://localhost:" + port + "/userApi/listUserResc";
        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", userId);
        map.put("key", SystemConst.SHIRO_SECRET_KEY);

        String result = HttpUtils.send(url, map);

        if (ToolUtil.isNotEmpty(result)) {
            List<Long> rescList = JSON.parseArray(result, Long.class);
            return rescList;
        } else {
            return null;
        }
    }


}
