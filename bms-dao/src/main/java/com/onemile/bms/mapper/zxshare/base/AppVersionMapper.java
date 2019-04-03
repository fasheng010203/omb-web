package com.onemile.bms.mapper.zxshare.base;

import com.onemile.bms.entity.zxshare.base.AppVersion;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.base.AppVersionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppVersionMapper extends BaseMapper<AppVersion> {
    List<AppVersionVO> listPage(Map<String,Object> map);

    AppVersionVO findByPlatform(@Param("platform") Integer platform);
}