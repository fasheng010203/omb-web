package com.onemile.bms.mapper.zxshare.company;

import com.onemile.bms.entity.zxshare.company.UserVerify;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.company.UserVerifyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserVerifyMapper extends BaseMapper<UserVerify> {
    List<UserVerifyVO> listPage(Map<String,Object> map);

    UserVerifyVO getByVerifyId(@Param("id") Long id);

    UserVerifyVO getByVerifyUserId(@Param("userId")Long userId);
}