package com.onemile.bms.mapper.zxshare.company;

import com.onemile.bms.entity.zxshare.company.UserInfo;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.pojo.vo.zxshare.company.UserInfoVO;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    List<UserInfoVO> listPage(Map<String,Object> map);
}