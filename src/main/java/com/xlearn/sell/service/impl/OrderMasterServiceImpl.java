package com.xlearn.sell.service.impl;

import com.xlearn.sell.dao.OrderMasterMapper;
import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:订单接口实现
 *
 * @author 轩辚
 * @date 2019/3/14 23:48
 */
public class OrderMasterServiceImpl implements OrderMasterService {

    /**
     * 注入
     */
    @Autowired
    private OrderMasterMapper orderMasterMapper;

    /**
     * 新增
     *
     * @param orderMaster 订单信息
     * @return 新增结果
     */
    @Override
    public int insert(OrderMaster orderMaster) {
        return orderMasterMapper.insert(orderMaster);
    }

    /**
     * 根据主键删除
     *
     * @param id 订单Id
     * @return 删除结果
     */
    @Override
    public int deleteById(String id) {
        return orderMasterMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param orderMaster 需要更新的订单对象
     * @return 更新的结果
     */
    @Override
    public int update(OrderMaster orderMaster) {
        return orderMasterMapper.updateByPrimaryKey(orderMaster);
    }

    /**
     * 更新指定内容
     *
     * @param orderMaster 需要更新的订单对象
     * @return 更新的结果
     */
    @Override
    public int updateSelective(OrderMaster orderMaster) {
        return orderMasterMapper.updateByPrimaryKeySelective(orderMaster);
    }

    /**
     * 根据主键查找
     *
     * @param id 订单id
     * @return 查询到的订单信息
     */
    @Override
    public OrderMaster findById(String id) {
        return orderMasterMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return 查询到的订单信息列表
     */
    @Override
    public List<OrderMaster> findAll() {
        return orderMasterMapper.findAll();
    }

    /**
     * 根据支付状态及是否关闭查询订单
     * @param payStatus 支付状态 0未支付，1已支付
     * @param orderStatus 订单状态 0新订单，1已关闭
     * @return 所有已支付订单
     */
    @Override
    public List<OrderMaster> findOrderByPayStatusAndOrderStatus(Integer payStatus,Integer orderStatus) {
        return orderMasterMapper.findOrderByPayStatusAndOrderStatus(payStatus,orderStatus);
    }
}
