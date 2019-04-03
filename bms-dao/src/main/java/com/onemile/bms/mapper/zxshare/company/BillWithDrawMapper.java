package com.onemile.bms.mapper.zxshare.company;

import com.onemile.bms.entity.zxshare.company.BillWithDraw;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.company.BillWithDrawVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillWithDrawMapper extends BaseMapper<BillWithDraw> {
    List<BillWithDrawVO> listPage(Map<String, Object> map);

    BillWithDrawVO getByBillWithDrawId(@Param("id") Long id);
}