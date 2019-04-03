package com.onemile.bms.mapper.zxshare.base;

import com.onemile.bms.entity.zxshare.base.BaseCity;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.base.BaseCityVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseCityMapper extends BaseMapper<BaseCity> {

    public List<BaseCityVO> findBaseCityByType(Integer type);

    public List<BaseCityVO> findBaseCityByParentId(Integer parentid);

    List<BaseCityVO> listPage(Map<String,Object> map);
}