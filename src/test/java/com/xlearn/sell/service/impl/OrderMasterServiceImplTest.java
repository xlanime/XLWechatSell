package com.xlearn.sell.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xlearn.sell.common.OrderStatusEnum;
import com.xlearn.sell.dto.OrderDto;
import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.vo.OrderInfoVo;
import com.xlearn.sell.vo.ProductItemVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:订单接口单元测试
 *
 * @author 轩辚
 * @date 2019/3/14 23:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterServiceImplTest {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    @Test
    public void insert() {
        //构造订单信息
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setBuyerName("谢轩辚");
        orderInfoVo.setBuyerAddress("南阳盛世");
        orderInfoVo.setBuyerPhone("17700001111");
        orderInfoVo.setBuyerOpenid("xlwechat");

        //构造订单详情信息，这里构造了两条
        List<ProductItemVo> productItemVoList = new ArrayList<>();
        ProductItemVo productItemVo1 = new ProductItemVo();
        productItemVo1.setProductId("5");
        productItemVo1.setProductQuantity(3);

        ProductItemVo productItemVo2 = new ProductItemVo();
        productItemVo2.setProductId("1");
        productItemVo2.setProductQuantity(10);

        productItemVoList.add(productItemVo1);
        productItemVoList.add(productItemVo2);

        //构造完整入参
        orderInfoVo.setProductItemVoList(productItemVoList);

        //测试下单接口
        String orderId = orderMasterService.insert(orderInfoVo);
        assertNotNull(orderId);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updateSelective() {
    }

    @Test
    public void findById() {
        OrderDto orderDto = orderMasterService.findById("66490420b7194ed5a48f54478030d232");
        log.info(JSONObject.toJSONString(orderDto));
        assertNotNull(orderDto);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findOrderByPayStatusAndOrderStatus() {
    }

    @Test
    public void orderCancel(){
        OrderDto orderDto = orderMasterService.orderCancel("66490420b7194ed5a48f54478030d232");
        log.info(JSONObject.toJSONString(orderDto));
        assertEquals(OrderStatusEnum.CANCEL.getCode(),orderDto.getOrderStatus());
    }
}