package com.onemile.bms.service.share.base.impl;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.zxshare.base.Suggest;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.zxshare.base.SuggestMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestQuery;
import com.onemile.bms.pojo.dto.zxshare.base.SuggestReq;
import com.onemile.bms.pojo.vo.zxshare.base.SuggestVO;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.share.base.SuggestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ericma
 */
@Service
public class SuggestServiceImpl extends BaseServiceImpl<Suggest> implements SuggestService {
    private Logger logger = LoggerFactory.getLogger(SuggestServiceImpl.class);

    @Autowired
    private SuggestMapper suggestMapper;

    @Override
    protected BaseMapper<Suggest> getBaseMapper() {
        return suggestMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<SuggestVO> getSuggestList(SuggestQuery suggestQuery) {
        Map<String, Object> map = new HashMap<>(7);
        map.put("id", suggestQuery.getId());
        map.put("title", suggestQuery.getTitle());
        map.put("mobile", suggestQuery.getMobile());
        map.put("status", suggestQuery.getStatus());
        map.put("beginDate", suggestQuery.getBeginDate());
        map.put("endDate", suggestQuery.getEndDate());
        //排序字段
        String strOrderBy = "";
        if (StringUtils.hasText(suggestQuery.getSidx())) {
            strOrderBy = suggestQuery.getSidx() + " " + suggestQuery.getSord();
        }
        PageInfo<SuggestVO> suggestVOPageInfo = PageHelper.startPage(suggestQuery.getPage(), suggestQuery.getRows(), strOrderBy).doSelectPageInfo(() -> suggestMapper.listPage(map));
        PageInfoRsp<SuggestVO> pageInfoRsp = PageInfoConverts.convert(suggestVOPageInfo);
        return pageInfoRsp;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public SuggestVO getBySuggestId(Long id) {
        return suggestMapper.getBySuggestId(id);
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public Boolean auditCompanyVerify(SuggestReq suggestReq) {
        Suggest suggest=new Suggest();
        suggest.setId(suggestReq.getId());
        suggest.setStatus(suggestReq.getStatus());
        suggestMapper.updateByPrimaryKeySelective(suggest);
        return true;
    }
}