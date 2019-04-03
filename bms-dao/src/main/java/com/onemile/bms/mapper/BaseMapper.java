package com.onemile.bms.mapper;

/**
 * @author Eric
 */
public interface BaseMapper<T> {
    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

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
    T selectByPrimaryKey(Long id);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 更新 可部分字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新 全部字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);


    /**
     * 根据单号删除 用于反审核
     *
     * @param orderId
     * @return
     */
    int deleteByOrderId(Long orderId);

}
