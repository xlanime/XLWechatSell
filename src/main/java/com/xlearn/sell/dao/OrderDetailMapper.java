package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:订单详情Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Mapper
@Component(value = "orderDetailMapper")
public interface OrderDetailMapper {
    /**
     * 根据主键删除
     * @param detailId 订单详情ID
     * @return 删除的结果
     */
    int deleteByPrimaryKey(String detailId);

    /**
     * 新增订单详情
     * @param record 订单详情实体类
     * @return 新增结果
     */
    int insert(OrderDetail record);

    /**
     * 新增订单详情（插入指定数据）
     * @param record 订单详情实体类
     * @return 新增结果
     */
    int insertSelective(OrderDetail record);

    /**
     * 根据主键查询
     * @param detailId 订单详情ID
     * @return 查询的结果
     */
    OrderDetail selectByPrimaryKey(String detailId);

    /**
     * 根据主键修改（修改指定内容）
     * @param record 订单详情实体类
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(OrderDetail record);

    /**
     * 根据主键修改
     * @param record 订单详情实体类
     * @return 修改结果
     */
    int updateByPrimaryKey(OrderDetail record);

    /**
     * 查询所有订单详情
     * @return 修改结果
     */
    List<OrderDetail> findAll();

    /**
     * 查询所有订单详情
     * @return 修改结果
     */
    List<OrderDetail> findByOrderId(String orderId);
}