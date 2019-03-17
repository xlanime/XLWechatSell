package com.xlearn.sell.service.impl;

import com.xlearn.sell.common.ResultEnum;
import com.xlearn.sell.dto.OrderDto;
import com.xlearn.sell.exception.SellException;
import com.xlearn.sell.service.BuyerService;
import com.xlearn.sell.service.OrderMasterService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/18 0:55
 */
@Service("buyerService")
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    private OrderMasterService orderMasterService;
    @Autowired
    public void setOrderMasterService(OrderMasterService orderMasterService) {
        this.orderMasterService = orderMasterService;
    }

    /**
     * 根据openId和orderId查询订单详情
     *
     * @param openId  微信openId
     * @param orderId 订单Id
     * @return 查询到的订单详情
     */
    @Override
    public OrderDto findOrderDetail(String openId, String orderId) {

        return checkOrderOwner(openId,orderId);
    }

    /**
     * 根据openId和orderId取消订单
     *
     * @param openId  微信openId
     * @param orderId 订单Id
     * @return 取消的订单详情
     */
    @Override
    public OrderDto orderCancel(String openId, String orderId) {
        OrderDto orderDto = checkOrderOwner(openId,orderId);
        if(null == orderDto){
            log.warn("【取消订单】没有查询到对应的订单，订单号：{}",orderId);
        }
        return orderMasterService.orderCancel(orderId);
    }

    /**
     * 检查openId与订单信息中的openId是否一致，以判断用户是否可以操作当前订单
     *
     * @param openId  微信openId
     * @param orderId 订单Id
     * @return 检查的订单对象
     */
    public OrderDto checkOrderOwner(String openId, String orderId){
        OrderDto orderDto = orderMasterService.findById(orderId);
        if(null == orderDto){
            log.warn("【检查订单】没有查询到对应的订单，订单号：{}",orderId);
            return null;
        }
        if(!orderDto.getBuyerOpenid().equalsIgnoreCase(openId)){
            log.warn("【检查订单】订单的openId不一致，openId={},orderDto中openId={}",openId,orderDto.getBuyerOpenid());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
