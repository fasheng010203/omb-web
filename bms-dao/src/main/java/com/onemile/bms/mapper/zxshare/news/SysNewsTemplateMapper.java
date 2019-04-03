package com.onemile.bms.mapper.zxshare.news;

import com.onemile.bms.entity.zxshare.news.SysNewsTemplate;
import com.onemile.bms.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysNewsTemplateMapper extends BaseMapper<SysNewsTemplate> {

    /**
     * 查询所有模板
     * @return 模板信息
     */
    List<SysNewsTemplate> findAllData();
}