package com.onemile.bms.mapper.zxshare.base;

import com.onemile.bms.entity.zxshare.base.SysMsgTemplate;
import com.onemile.bms.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 */
@Repository
public interface SysMsgTemplateMapper extends BaseMapper<SysMsgTemplate> {

    /**
     * 查询系统信息模板
     *
     * @return
     */
    List<SysMsgTemplate> listMsgTemp();
}