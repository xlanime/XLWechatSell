package com.xlearn.sell.service.impl;

import com.xlearn.sell.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Description:订单详情接口单元测试
 *
 * @author 轩辚
 * @date 2019/3/14 23:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderDetailServiceImplTest {

    /**
     * 注入Service
     */
    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    /**
     * 新增测试
     */
    @Test
    public void insert() {
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteById() {
    }

    /**
     * 修改测试
     */
    @Test
    public void update() {
    }

    /**
     * 修改指定内容测试
     */
    @Test
    public void updateSelective() {
    }

    /**
     * 根据主键查找测试
     */
    @Test
    public void findById() {
        log.info("开始查询id为1的订单详情...");
        OrderDetail orderDetail = orderDetailService.findById("1");
        assertNotNull(orderDetail);
        if(orderDetail!= null) {
            assertEquals("1", orderDetail.getDetailId());
        }
    }

    /**
     * 查找所有测试
     */
    @Test
    public void findAll() {
    }
}