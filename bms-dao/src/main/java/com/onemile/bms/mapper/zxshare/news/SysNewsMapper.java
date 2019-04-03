package com.onemile.bms.mapper.zxshare.news;

import com.onemile.bms.entity.zxshare.news.SysNews;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.dto.zxshare.news.SysNewsQuery;
import com.onemile.bms.pojo.vo.zxshare.news.SysNewsVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysNewsMapper extends BaseMapper<SysNews> {
    /**
     * 分页查询
     *
     * @param sysNewsQuery
     * @return 资讯信息
     */
    List<SysNewsVO> listPage(SysNewsQuery sysNewsQuery);
}