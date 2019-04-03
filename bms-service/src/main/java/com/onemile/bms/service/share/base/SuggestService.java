package com.onemile.bms.service.share.base;

import com.onemile.bms.entity.zxshare.base.Suggest;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestQuery;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestReq;
import com.onemile.bms.pojo.vo.zxshare.base.SuggestVO;
import com.onemile.bms.service.base.BaseService;

public interface SuggestService extends BaseService<Suggest> {

    /**
     * 列表
     * @param suggestQuery
     * @return
     */
    PageInfoRsp<SuggestVO> getSuggestList(SuggestQuery suggestQuery);

    SuggestVO getBySuggestId(Long id);

    Boolean auditCompanyVerify(SuggestReq suggestReq);
}