package com.onemile.bms.mapper.zxshare.operate;

import com.onemile.bms.entity.zxshare.operate.Banner;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.operate.BannerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BannerMapper extends BaseMapper<Banner> {
    List<BannerVO> listPage(Map<String,Object> map);

    BannerVO getByBannerId(@Param("id") Long id);
}