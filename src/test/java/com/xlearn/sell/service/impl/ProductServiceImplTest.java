package com.xlearn.sell.service.impl;

import com.github.pagehelper.PageHelper;
import com.xlearn.sell.common.ProductSaleStatusEnum;
import com.xlearn.sell.pojo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void insert() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("测试");
        productInfo.setProductPrice(new BigDecimal(1.00));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("测试商品");
        productInfo.setProductIcon("testUrl");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);


        int result = productService.insert(productInfo);
        Assert.assertEquals(1,result);
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
    }

    @Test
    public void findAll() {
        //查询所有商品,如果查询到商品认为测试通过
        PageHelper.startPage(2,3);
        List<ProductInfo> productInfos = productService.findAll();
        int index = 1;
        for(ProductInfo productInfo:productInfos){
            log.info("第{}条数据：{}",index,productInfo.toString());
        }
        assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findBySaleStatus(){
        PageHelper.startPage(2,3);
        //查询所有在售商品,如果查询到商品认为测试通过
        List<ProductInfo> productInfos = productService.findBySaleStatus(ProductSaleStatusEnum.UP.getCode());
        int index = 1;
        for(ProductInfo productInfo:productInfos){
            log.info("第{}条数据：{}",index,productInfo.toString());
        }
        assertNotEquals(0,productInfos.size());
    }
}