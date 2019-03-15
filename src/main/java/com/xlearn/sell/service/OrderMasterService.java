package com.xlearn.sell.service;

import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.vo.OrderInfoVo;

import java.util.List;

/**
 * Description:订单接口
 *
 * @author 轩辚
 * @date 2019/3/14 23:45
 */
public interface OrderMasterService {
    /**
     * 新增
     * @param orderInfoVo 订单信息
     * @return 新增结果
     */
    OrderInfoVo insert(OrderInfoVo orderInfoVo);

    /**
     * 根据主键删除
     * @param id 订单Id
     * @return 删除结果
     */
    int deleteById(String id);

    /**
     * 更新
     * @param orderMaster 需要更新的订单对象
     * @return 更新的结果
     */
    int update(OrderMaster orderMaster);

    /**
     * 更新指定内容
     * @param orderMaster 需要更新的订单对象
     * @return 更新的结果
     */
    int updateSelective(OrderMaster orderMaster);

    /**
     * 根据主键查找
     * @param id 订单id
     * @return 查询到的订单信息
     */
    OrderInfoVo findById(String id);

    /**
     * 查询用户当前页的订单列表
     * @param openId 用户微信openid
     * @return 查询到的订单信息列表
     */
    List<OrderInfoVo> findListByOpenId(String openId);

    /**
     * 查询所有
     * @return 查询到的订单信息列表
     */
    List<OrderMaster> findAll();

    /**
     * 根据支付状态及是否关闭查询订单
     * @param payStatus 支付状态 0未支付，1已支付
     * @param orderStatus 订单状态 0新订单，1已关闭
     * @return 所有已支付订单
     */
    List<OrderMaster> findOrderByPayStatusAndOrderStatus(Integer payStatus,Integer orderStatus);

    /**
     * 取消订单
     * @param orderId 需要取消的订单Id
     * @return 取消的结果
     */
    OrderMaster orderCancel(String orderId);
}
