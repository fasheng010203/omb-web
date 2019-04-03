package com.onemile.bms.mapper.zxshare.company;

import com.onemile.bms.entity.zxshare.company.UserBank;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.company.UserBankVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserBankMapper extends BaseMapper<UserBank> {
    List<UserBankVO> listPage(Map<String,Object> map);

    UserBankVO getByBankCardId(@Param("id") Long id);

    UserBankVO getByBankUserId(@Param("userId")Long userId);
}