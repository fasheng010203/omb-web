package com.onemile.bms.service.share.base;

import com.onemile.bms.entity.zxshare.base.AppVersion;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.zxshare.base.AppVersionQuery;
import com.onemile.bms.pojo.dto.zxshare.base.AppVersionReq;
import com.onemile.bms.pojo.vo.zxshare.base.AppVersionVO;
import com.onemile.bms.service.base.BaseService;

/**
 * @author ericma
 */
public interface AppVersionService extends BaseService<AppVersion> {
    /**
     * 列表
     * @param appVersionQuery
     * @return
     */
    PageInfoRsp<AppVersionVO> getAppVersionList(AppVersionQuery appVersionQuery);

    /**
     * 增加
     * @param appVersionReq
     * @return
     */
    Boolean saveAppVersion(AppVersionReq appVersionReq);

    /**
     * 修改
     * @param appVersionReq
     * @return
     */
    Boolean updateAppVersion(AppVersionReq appVersionReq);

    /**
     * 根据版本号查询
     * @param platform
     * @return
     */
    AppVersionVO findByPlatform(Integer platform);
}