package com.xlearn.sell.vo;

import lombok.Data;

/**
 * Description:前端传入的订单中的商品信息
 *
 * @author 轩辚
 * @date 2019/3/15 18:12
 */
@Data
public class ProductItemVo {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public ProductItemVo(){}

    public ProductItemVo(String productId,Integer productQuantity){
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
