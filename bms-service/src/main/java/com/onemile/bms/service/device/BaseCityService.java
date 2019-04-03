package com.onemile.bms.service.device;



import com.onemile.bms.entity.zxshare.base.BaseCity;
import com.onemile.bms.page.PageInfoRsp;
import com.onemile.bms.pojo.dto.device.BaseCityQuery;
import com.onemile.bms.pojo.vo.zxshare.base.BaseCityVO;
import com.onemile.bms.service.base.BaseService;

import java.util.List;

public interface BaseCityService extends BaseService<BaseCity> {
    /**
     * 获取城市
     * @param type 类型
     * @return
     */
    List<BaseCityVO> getBaseCityByType(Integer type);

    /**
     * 获取下级城市
     * @param praentid 类型
     * @return
     */
    List<BaseCityVO> getBaseCityByParentId(Integer praentid);

    /**
     * 查询List
     * @param baseCityQuery
     * @return
     */
    PageInfoRsp<BaseCityVO> getBaseCityList(BaseCityQuery baseCityQuery);


}