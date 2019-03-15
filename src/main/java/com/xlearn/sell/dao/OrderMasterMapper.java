package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:订单主表Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Mapper
@Component(value = "orderMasterMapper")
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

    /**
     * 查询所有订单详情
     * @return 修改结果
     */
    List<OrderMaster> findAll();

    /**
     * 根据支付状态及是否关闭查询订单
     * @param payStatus 支付状态 0未支付，1已支付
     * @param orderStatus 订单状态 0新订单，1已关闭
     * @return 所有已支付订单
     */
    List<OrderMaster> findOrderByPayStatusAndOrderStatus(@Param(value = "payStatus") Integer payStatus,
                                                         @Param(value = "orderStatus") Integer orderStatus);

    /**
     * 查询所有订单详情
     * @return 修改结果
     */
    List<OrderMaster> findListByOpenId(String openId);

}