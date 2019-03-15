package com.xlearn.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:返回给前端的商品信息对象
 *  根据接口API，只返回API需要的属性
 *
 * @author 轩辚
 * @date 2019/3/15 12:15
 */
@Data
public class ProductInfoVo {

    /**
     * 商品ID
     */
    @JsonProperty("id")
    private String productId;

    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 商品价格
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 商品简介
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 商品图片
     */
    @JsonProperty("icon")
    private String productIcon;
}
