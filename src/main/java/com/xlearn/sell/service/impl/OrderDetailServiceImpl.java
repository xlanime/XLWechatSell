package com.xlearn.sell.service.impl;

import com.xlearn.sell.dao.OrderDetailMapper;
import com.xlearn.sell.pojo.OrderDetail;
import com.xlearn.sell.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:订单详情接口实现
 *
 * @author 轩辚
 * @date 2019/3/14 23:47
 */
@Service("orderDetailService")
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {

    /**
     * 注入orderDetailMapper
     */
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 新增
     *
     * @param orderDetail 订单详情信息
     * @return 新增结果
     */
    @Override
    public int insert(OrderDetail orderDetail) {
        return orderDetailMapper.insert(orderDetail);
    }

    /**
     * 根据主键删除
     *
     * @param id 订单详情Id
     * @return 删除结果
     */
    @Override
    public int deleteById(String id) {
        return orderDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param orderDetail 需要更新的订单详情对象
     * @return 更新的结果
     */
    @Override
    public int update(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKey(orderDetail);
    }

    /**
     * 更新指定内容
     *
     * @param orderDetail 需要更新的订单详情对象
     * @return 更新的结果
     */
    @Override
    public int updateSelective(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    /**
     * 根据主键查找
     *
     * @param id 订单详情id
     * @return 查询到的订单详情信息
     */
    @Override
    public OrderDetail findById(String id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return 查询到的订单详情信息列表
     */
    @Override
    public List<OrderDetail> findAll() {
        return orderDetailMapper.findAll();
    }
}
