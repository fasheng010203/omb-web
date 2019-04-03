package com.onemile.bms.mapper.zxshare.news;

import com.onemile.bms.entity.zxshare.news.SysNewsText;
import com.onemile.bms.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SysNewsTextMapper extends BaseMapper<SysNewsText> {

    public SysNewsText findSysNewsTextById(Long newsId);
}