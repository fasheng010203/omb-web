package com.onemile.bms.service.base.impl;


import com.onemile.bms.datasource.annotation.DbMsEnum;
import com.onemile.bms.datasource.annotation.SwitchDs;
import com.onemile.bms.mapper.BaseMapper;
import com.onemile.bms.service.base.BaseService;

/**
 * 基础Service接口
 *
 * @param <T>
 * @author
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int deleteById(Long id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int deleteById(Integer id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int insert(T record) {
        return getBaseMapper().insert(record);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int insertSelective(T record) {
        return getBaseMapper().insertSelective(record);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public T getById(Long id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public T getById(Integer id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int updateSelective(T record) {
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    @SwitchDs(ms = DbMsEnum.BMS)
    public int update(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }


}
