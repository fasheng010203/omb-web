package com.onemile.bms.service.base;

/**
 * 分页列表查询
 *
 * @param condition
 * @return
 */

/**
 * 基础Service接口
 *
 * @author
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 新增 包含全部字段
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 新增 可部分字段
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 更新 可部分字段
     *
     * @param record
     * @return
     */
    int updateSelective(T record);

    /**
     * 更新 全部字段
     *
     * @param record
     * @return
     */
    int update(T record);

}
