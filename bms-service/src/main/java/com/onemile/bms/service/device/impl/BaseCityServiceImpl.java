package com.onemile.bms.service.device.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.entity.zxshare.base.BaseCity;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.mapper.zxshare.base.BaseCityMapper;
import com.onemile.bms.page.PageInfoConverts;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.BaseCityQuery;
import com.onemile.bms.pojo.vo.zxshare.base.BaseCityVO;
import com.onemile.bms.service.base.impl.BaseServiceImpl;
import com.onemile.bms.service.device.BaseCityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseCityServiceImpl extends BaseServiceImpl<BaseCity> implements BaseCityService {
    private Logger logger = LoggerFactory.getLogger(BaseCityServiceImpl.class);

    @Autowired
    private BaseCityMapper baseCityMapper;

    @Override
    protected BaseMapper<BaseCity> getBaseMapper() {
        return baseCityMapper;
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List<BaseCityVO> getBaseCityByType(Integer type) {
        return baseCityMapper.findBaseCityByType(type);
    }


    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public List<BaseCityVO> getBaseCityByParentId(Integer parentid) {
        return baseCityMapper.findBaseCityByParentId(parentid);
    }

    @Override
    @SwitchDs(ms=DbMsEnum.BMS)
    public PageInfoRsp<BaseCityVO> getBaseCityList(BaseCityQuery baseCityQuery) {
        Map<String, Object> map = new HashMap<>(4);

        map.put("parentId", baseCityQuery.getParentId());
        map.put("userId", baseCityQuery.getUserId());

        //排序字段
        String strOrderBy = "";
//        if (StringUtils.hasText(baseCityVO.getId().toString())) {
//            strOrderBy = baseCityVO.getId().toString();
//        }
        PageInfo<BaseCityVO> pageInfo = PageHelper.startPage(baseCityQuery.getPage(), baseCityQuery.getRows(), strOrderBy).doSelectPageInfo(() -> baseCityMapper.listPage(map));
        PageInfoRsp<BaseCityVO> pageInfoRsp=PageInfoConverts.convert(pageInfo);
        return pageInfoRsp;
    }

}