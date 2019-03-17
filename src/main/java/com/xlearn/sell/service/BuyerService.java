package com.xlearn.sell.service;

import com.xlearn.sell.dto.OrderDto;

/**
 * Description:买家相关业务接口
 *
 * @author 轩辚
 * @date 2019/3/18 0:55
 */
public interface BuyerService {

    /**
     * 根据openId和orderId查询订单详情
     * @param openId 微信openId
     * @param orderId 订单Id
     * @return 查询到的订单详情
     */
    OrderDto findOrderDetail(String openId,String orderId);

    /**
     * 根据openId和orderId取消订单
     * @param openId 微信openId
     * @param orderId 订单Id
     * @return 取消的订单详情
     */
    OrderDto orderCancel(String openId,String orderId);
}
