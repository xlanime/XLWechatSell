package com.xlearn.sell.service;

import com.xlearn.sell.pojo.OrderDetail;

import java.util.List;

/**
 * Description:订单详情接口
 *
 * @author 轩辚
 * @date 2019/3/14 23:43
 */
public interface OrderDetailService {
    /**
     * 新增
     * @param orderDetail 订单详情信息
     * @return 新增结果
     */
    int insert(OrderDetail orderDetail);

    /**
     * 根据主键删除
     * @param id 订单详情Id
     * @return 删除结果
     */
    int deleteById(String id);

    /**
     * 更新
     * @param orderDetail 需要更新的订单详情对象
     * @return 更新的结果
     */
    int update(OrderDetail orderDetail);

    /**
     * 更新指定内容
     * @param orderDetail 需要更新的订单详情对象
     * @return 更新的结果
     */
    int updateSelective(OrderDetail orderDetail);

    /**
     * 根据主键查找
     * @param id 订单详情id
     * @return 查询到的订单详情信息
     */
    OrderDetail findById(String id);

    /**
     * 查询所有
     * @return 查询到的订单详情信息列表
     */
    List<OrderDetail> findAll();
}
