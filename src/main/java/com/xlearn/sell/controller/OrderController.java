package com.xlearn.sell.controller;

import com.xlearn.sell.common.ServerResponse;
import com.xlearn.sell.service.impl.OrderMasterServiceImpl;
import com.xlearn.sell.vo.OrderInfoVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:订单接口
 *
 * @author 轩辚
 * @date 2019/3/15 17:31
 */
@RestController
@RequestMapping("/buyer/order")
public class OrderController {

    /**
     * 注入service
     */
    private OrderMasterServiceImpl orderMasterService;

    /**
     * 获取订单列表
     * @return 获取到的订单列表
     */
    @RequestMapping("/list")
    public ServerResponse getOrderList(){
        return null;
    }

    /**
     * 创建订单
     * @return 创建新的订单
     */
    @RequestMapping("/create")
    public ServerResponse createOrder(OrderInfoVo orderInfoVo){
        orderMasterService.insert(orderInfoVo);
        return null;
    }
}
