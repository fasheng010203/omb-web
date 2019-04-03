package com.onemile.bms.service.share.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.zxshare.base.AppVersion;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.zxshare.base.AppVersionMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.zxshare.base.AppVersionQuery;
import com.onemile.bms.pojo.dto.zxshare.base.AppVersionReq;
import com.onemile.bms.pojo.vo.zxshare.base.AppVersionVO;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.share.base.AppVersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ericma
 */
@Service
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersion> implements AppVersionService {
    private Logger logger = LoggerFactory.getLogger(AppVersionServiceImpl.class);

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    protected BaseMapper<AppVersion> getBaseMapper() {
        return appVersionMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<AppVersionVO> getAppVersionList(AppVersionQuery appVersionQuery) {
        Map<String, Object> map = new HashMap<>(7);
        map.put("verison", appVersionQuery.getVerison());
        map.put("beginDate", appVersionQuery.getBeginDate());
        map.put("endDate", appVersionQuery.getEndDate());
        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(appVersionQuery.getSidx())) {
            strOrderBy = appVersionQuery.getSidx() + " " + appVersionQuery.getSord();
        }
        PageInfo<AppVersionVO> appVersionVOPageInfo = PageHelper.startPage(appVersionQuery.getPage(), appVersionQuery.getRows(), strOrderBy).doSelectPageInfo(() -> appVersionMapper.listPage(map));
        PageInfoRsp<AppVersionVO> pageInfoRsp = PageInfoConverts.convert(appVersionVOPageInfo);
        return pageInfoRsp;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean saveAppVersion(AppVersionReq appVersionReq) {
        AppVersion appVersion=new AppVersion();
        appVersion.setPlatform(appVersionReq.getPlatform());
        appVersion.setVerison(appVersionReq.getVerison());
        appVersion.setDescription(appVersionReq.getDescription());
        appVersion.setIsForceUpdate(appVersionReq.getIsForceUpdate());
        appVersion.setDownUrl(appVersionReq.getDownUrl());
        appVersion.setGmtCreate(new Date());
        appVersion.setGmtModified(new Date());
        appVersionMapper.insertSelective(appVersion);
        return true;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean updateAppVersion(AppVersionReq appVersionReq) {
        AppVersion appVersion=new AppVersion();
        appVersion.setId(appVersionReq.getId());
        appVersion.setVerison(appVersionReq.getVerison());
        appVersion.setDescription(appVersionReq.getDescription());
        appVersion.setIsForceUpdate(appVersionReq.getIsForceUpdate());
        appVersion.setDownUrl(appVersionReq.getDownUrl());
        appVersion.setGmtModified(new Date());
        appVersionMapper.updateByPrimaryKeySelective(appVersion);
        return true;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public AppVersionVO findByPlatform(Integer platform) {
        return appVersionMapper.findByPlatform(platform);
    }
}