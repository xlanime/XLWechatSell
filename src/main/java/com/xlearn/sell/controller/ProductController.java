package com.xlearn.sell.controller;

import com.xlearn.sell.common.ProductSaleStatusEnum;
import com.xlearn.sell.common.ServerResponse;
import com.xlearn.sell.pojo.ProductCategory;
import com.xlearn.sell.pojo.ProductInfo;
import com.xlearn.sell.service.impl.ProductCategoryServiceImpl;
import com.xlearn.sell.service.impl.ProductServiceImpl;
import com.xlearn.sell.vo.ProductInfoVo;
import com.xlearn.sell.vo.ProductListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:商品信息接口入口
 *
 * @author 轩辚
 * @date 2019/3/15 12:10
 */
@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    /**
     * 注入Service
     */
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    /**
     * 获取在售商品列表
     * 1.查询所有的上架的商品
     * 2.查询出所有的泪目
     * 3.按照API进行数据封装：
     *     遍历商品类目，并且将对应类目的商品逐个封装到出参中。
     * @return 查询到的所有在售商品列表
     */
    @GetMapping("/list")
    public ServerResponse getOnsaleProductList(){
        //查询出所有在售的商品
        List<ProductInfo> onSaleProductInfoList =productService.findBySaleStatus(ProductSaleStatusEnum.UP.getCode());

        //查询出所有的类目
        List<ProductCategory> productCategoryList = productCategoryService.findAll();

        //封装后的ProductVo列表
        List<ProductListVo> productListVoList = new ArrayList<>();
        //按照API进行数据封装
        //首先遍历类目
        for(ProductCategory productCategory : productCategoryList){
            //获取到类目的编号
            int categoryType = productCategory.getCategoryType();

            //封装后的ProductVo列表
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            //遍历商品列表，将对应类目的商品封装到出参
            for(ProductInfo productInfo : onSaleProductInfoList){
                if(productInfo.getCategoryType() == categoryType){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //利用BeanUtils进行属性拷贝
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }

            ProductListVo productListVo = new ProductListVo();
            productListVo.setCategoryName(productCategory.getCategoryName());
            productListVo.setCategoryType(productCategory.getCategoryType());
            productListVo.setProductVoList(productInfoVoList);
            productListVoList.add(productListVo);
        }

        return ServerResponse.createBySuccess("获取商品信息成功",productListVoList);
    }
}
