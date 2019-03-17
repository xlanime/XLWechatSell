package com.xlearn.sell.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.xlearn.sell.common.Consts;
import com.xlearn.sell.common.ResultEnum;
import com.xlearn.sell.common.ServerResponse;
import com.xlearn.sell.converter.OrderForm2OrderInfoVoConverter;
import com.xlearn.sell.dto.OrderDto;
import com.xlearn.sell.exception.SellException;
import com.xlearn.sell.form.OrderForm;
import com.xlearn.sell.service.impl.OrderMasterServiceImpl;
import com.xlearn.sell.vo.OrderInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:订单接口
 *
 * @author 轩辚
 * @date 2019/3/15 17:31
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class OrderController {

    /**
     * 注入service
     */
    private OrderMasterServiceImpl orderMasterService;
    @Autowired
    public void setOrderMasterService(OrderMasterServiceImpl orderMasterService) {
        this.orderMasterService = orderMasterService;
    }

    /**
     * 获取订单列表
     * @return 获取到的订单列表
     */
    @GetMapping("/list")
    public ServerResponse getOrderList(@RequestParam("openid") String openid,
                                       @RequestParam(value = "page",defaultValue = "0")Integer page,
                                       @RequestParam(value = "size",defaultValue = "10")Integer size){
        //判断openid是否为空，为空说明不正确
        if(StringUtils.isEmpty(openid)){
            log.warn("【获取订单列表】openid为空");
            throw new SellException(ResultEnum.OPENID_EMPTY);
        }
        //获取列表
        PageHelper.startPage(page,size);
        List<OrderDto> orderDtoList = orderMasterService.findOrderByPayStatusAndOrderStatus(null,null);
        return ServerResponse.createBySuccess(Consts.GET_ORDER_LIST_SUCCESS,orderDtoList);
    }

    /**
     * 创建订单
     * @return 创建新的订单
     */
    @PostMapping("/create")
    public ServerResponse createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.warn("【创建订单】订单参数不正确,orderForm = {}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderInfoVo orderInfoVo = OrderForm2OrderInfoVoConverter.convert(orderForm);
        //订单详情不能为空
        if(null == orderInfoVo.getProductItemVoList()){
            log.warn("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        String orderId = orderMasterService.insert(orderInfoVo);
        JSONObject orderIdJson = new JSONObject();
        orderIdJson.put("orderId",orderId);

        return ServerResponse.createBySuccess(Consts.CREATE_ORDER_SUCCESS,orderIdJson);
    }

    /**
     * 订单详情
     * @return 获取订单的详情信息
     */
    @GetMapping("/detail")
    public ServerResponse orderDetail(@RequestParam("openid")String openId,
                                      @RequestParam("orderId") String orderId){
        orderMasterService.findById(orderId);
        return ServerResponse.createBySuccess();
    }

    /**
     * 取消订单
     * @return 取消订单的结果
     */
    @PostMapping("/cancel")
    public ServerResponse orderCancel(@RequestParam("openid")String openId,
                                      @RequestParam("orderId") String orderId){
        orderMasterService.orderCancel(orderId);
        return null;
    }
}
