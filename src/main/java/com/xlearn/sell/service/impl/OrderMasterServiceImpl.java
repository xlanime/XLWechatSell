package com.xlearn.sell.service.impl;

import com.xlearn.sell.common.OrderStatusEnum;
import com.xlearn.sell.common.PayStatusEnum;
import com.xlearn.sell.common.ResultEnum;
import com.xlearn.sell.converter.OrderMaster2OrderDtoConverter;
import com.xlearn.sell.converter.OrderMaster2OrderInfoVoConverter;
import com.xlearn.sell.dao.OrderMasterMapper;
import com.xlearn.sell.dto.OrderDto;
import com.xlearn.sell.exception.SellException;
import com.xlearn.sell.pojo.OrderDetail;
import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.pojo.ProductInfo;
import com.xlearn.sell.service.OrderMasterService;
import com.xlearn.sell.utils.BigDecimalUtil;
import com.xlearn.sell.utils.UUIDUtil;
import com.xlearn.sell.vo.OrderInfoVo;
import com.xlearn.sell.vo.ProductItemVo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:订单接口实现
 *
 * @author 轩辚
 * @date 2019/3/14 23:48
 */
@Service("orderMasterService")
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService {

    /**
     * 注入Service
     */
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    public void setOrderMasterMapper (OrderMasterMapper orderMasterMapper) {
        this.orderMasterMapper = orderMasterMapper;
    }

    private ProductServiceImpl productService;
    @Autowired
    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    public void setOrderDetailService(OrderDetailServiceImpl orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * 新增订单
     * 1.查询商品（数量、价格）
     * 2.计算总价
     * 3.写入订单数据库（orderMaster和orderDetail）
     * 4.扣库存数量
     *
     * @param orderInfoVo 订单信息
     * @return 新增结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insert(OrderInfoVo orderInfoVo) {
        //获得UUID
        String orderId = UUIDUtil.getShortUUID();
        log.info("开始创建订单，订单id为{}",orderId);
        //初始化订单总价，并初始化为0
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1.查询商品
        //首先从订单信息中获取到商品信息列表
        List<ProductItemVo> productItemVoList = orderInfoVo.getProductItemVoList();
        for (ProductItemVo productItemVo : productItemVoList){
            ProductInfo productInfo = productService.findById(productItemVo.getProductId());
            if(null == productInfo){
                log.warn("没有找到对应商品，商品ID：{}",productItemVo.getProductId());
                //如果没有找到对应的商品说明不正常
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
            orderAmount = BigDecimalUtil.add(orderAmount.doubleValue(),BigDecimalUtil.multiply(
                    productInfo.getProductPrice().doubleValue(),productItemVo.getProductQuantity()).doubleValue());
            //3.1 订单详情入库
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(productInfo,orderDetail);
            BeanUtils.copyProperties(productItemVo,orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(UUIDUtil.getShortUUID());
            orderDetailService.insert(orderDetail);
            log.info("订单详情入库完成，订单详情ID：{}",orderDetail.getDetailId());
        }
        //3.2 订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderInfoVo,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(orderId);
        orderMasterMapper.insert(orderMaster);
        log.info("订单入库完成");

        //4.扣减库存
        productService.decreaseStock(productItemVoList);
        log.info("扣减库存完成，订单创建完毕");
        return orderId;
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
    public OrderDto findById(String id) {
        OrderMaster orderMaster = orderMasterMapper.selectByPrimaryKey(id);
        if(null == orderMaster){
            //订单不存在
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailService.findByOrderId(id);
        if(CollectionUtils.isEmpty(orderDetailList)){
            //订单详情不存在
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        //按照API封装出参
//        OrderInfoVo orderInfoVo = new OrderInfoVo();
//        BeanUtils.copyProperties(orderMaster,orderInfoVo);
//        List<ProductItemVo> productItemVoList = new ArrayList<>();
//        for(OrderDetail orderDetail:orderDetailList){
//            ProductItemVo productItemVo = new ProductItemVo();
//            BeanUtils.copyProperties(orderDetail,productItemVo);
//            productItemVoList.add(productItemVo);
//        }
//        orderInfoVo.setProductItemVoList(productItemVoList);
        return OrderMaster2OrderDtoConverter.convert(orderMaster);
    }

    /**
     * 查询用户当前页的订单列表
     * @param openId 用户微信openid
     * @return 查询到的订单信息列表
     */
    @Override
    public List<OrderInfoVo> findListByOpenId(String openId){
        List<OrderMaster> orderMasterList = orderMasterMapper.findListByOpenId(openId);
        List<OrderInfoVo> orderInfoVoList = OrderMaster2OrderInfoVoConverter.convert(orderMasterList);
        return orderInfoVoList;
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
    public List<OrderDto> findOrderByPayStatusAndOrderStatus(Integer payStatus,Integer orderStatus) {

        List<OrderMaster> orderMasterList = orderMasterMapper.findOrderByPayStatusAndOrderStatus(payStatus,orderStatus);
        List<OrderDto> orderDtoList = OrderMaster2OrderDtoConverter.convert(orderMasterList);
        return orderDtoList;
    }

    /**
     * 取消订单：
     * 1.判断订单的状态（符合要求的订单才能被取消）
     * 2.修改订单状态
     * 3.返还库存数据
     * 4.如果已支付需要进行退款
     *
     * @param orderId 需要取消的订单
     * @return 取消的结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDto orderCancel(String orderId) {
        OrderMaster orderMaster = orderMasterMapper.selectByPrimaryKey(orderId);
        if(null == orderMaster){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //1.判断订单状态：只有“新订单”状态的订单可以取消
        if(!OrderStatusEnum.NEW.getCode().equals(orderMaster.getOrderStatus())){
            log.warn("【取消订单】当前订单{},订单状态为{},不支持取消",orderId,orderMaster.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_CAN_NOT_CANCEL);
        }

        //2.修改订单状态为已取消，并保存到数据库
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        int updateResult = orderMasterMapper.updateByPrimaryKey(orderMaster);
        if(updateResult < 1){
            log.warn("【取消订单】订单{}取消失败",orderId);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //3.返还库存
        List<OrderDetail> orderDetailList = orderDetailService.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList)){
            log.warn("【取消订单】订单{} 订单详情为空",orderId);
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        List<ProductItemVo> productItemVoList = orderDetailList.stream().map(e->
                new ProductItemVo(e.getProductId(),e.getProductQuantity())).
                collect(Collectors.toList());
        productService.increaseStock(productItemVoList);

        //4.如果已支付需要进行退款
        if(PayStatusEnum.SUCCESS.getCode().equals(orderMaster.getPayStatus())){
            //Todo 完成支付相关的代码
        }

        return OrderMaster2OrderDtoConverter.convert(orderMaster);
    }

    /**
     * 结束订单:
     *  1.判断订单状态：只有新下单的订单可以结束
     *  2.修改订单状态并保存到数据库
     *
     * @param orderDto 需要结束的订单
     * @return 结束订单的结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDto orderFinish(OrderDto orderDto) {
        //1.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderDto.getOrderStatus())){
            log.warn("【结束订单】当前订单{},订单状态为{},不支持结束",orderDto.getOrderId(),orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_CAN_NOT_CANCEL);
        }
        //2.修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        updateOrderStatus(orderDto);
        return orderDto;
    }

    /**
     * 支付订单
     * 1.判断订单状态（只有新创建的订单可以支付）
     * 2.判断支付状态（只有未支付的订单可以支付）
     * 3.修改支付状态
     *
     * @param orderDto 需要支付的订单
     * @return 支付的结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDto orderPay(OrderDto orderDto) {
        //1.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderDto.getOrderStatus())){
            log.warn("【支付订单】当前订单{},订单状态为{},不支持支付",orderDto.getOrderId(),orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_CAN_NOT_CANCEL);
        }
        //2.判断支付状态
        if(!PayStatusEnum.WAIT.getCode().equals(orderDto.getPayStatus())){
            log.warn("【支付订单】当前订单{},订单状态为{},不支持支付",orderDto.getOrderId(),orderDto.getPayStatus());
            throw new SellException(ResultEnum.ORDER_CAN_NOT_PAY);
        }
        //3.修改订单状态
        orderDto.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        updateOrderStatus(orderDto);
        return orderDto;
    }

    /**
     * 修改订单状态
     * @param orderDto 需要修改状态的订单
     */
    private void updateOrderStatus(OrderDto orderDto){
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        int finishResult = orderMasterMapper.updateByPrimaryKeySelective(orderMaster);
        if(finishResult < 1){
            log.warn("订单{}修改状态出错",orderDto.getOrderId());
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
    }
}
