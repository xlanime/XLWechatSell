package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.OrderMaster;

/**
 * Description:订单主表Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
public interface OrderMasterMapper {
    /**
     * 根据主键删除
     * @param orderId 订单ID
     * @return 删除的结果
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 新增订单信息
     * @param record 订单实体类
     * @return 新增结果
     */
    int insert(OrderMaster record);

    /**
     * 新增订单信息（插入指定数据）
     * @param record 订单实体类
     * @return 新增结果
     */
    int insertSelective(OrderMaster record);

    /**
     * 根据主键查询
     * @param orderId 订单详情ID
     * @return 查询的结果
     */
    OrderMaster selectByPrimaryKey(String orderId);

    /**
     * 根据主键修改（修改指定内容）
     * @param record 订单实体类
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(OrderMaster record);

    /**
     * 根据主键修改
     * @param record 订单实体类
     * @return 修改结果
     */
    int updateByPrimaryKey(OrderMaster record);
}