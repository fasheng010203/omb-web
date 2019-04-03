package com.onemile.bms.mapper.zxshare.base;

import com.onemile.bms.entity.zxshare.base.Suggest;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.base.SuggestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SuggestMapper extends BaseMapper<Suggest> {
    List<SuggestVO> listPage(Map<String,Object> map);

    SuggestVO getBySuggestId(@Param("id") Long id);
}