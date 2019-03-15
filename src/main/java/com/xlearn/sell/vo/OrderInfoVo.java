package com.xlearn.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:前端传入的订单信息
 *
 * @author 轩辚
 * @date 2019/3/15 18:10
 */
@Data
public class OrderInfoVo {
    /**
     * 用户名
     */
    @JsonProperty("name")
    private String buyerName;

    /**
     * 电话
     */
    @JsonProperty("phone")
    private String buyerPhone;

    /**
     * 地址
     */
    @JsonProperty("address")
    private String buyerAddress;

    /**
     * 微信openid
     */
    @JsonProperty("openid")
    private String buyerOpenid;

    /**
     * 商品信息列表
     */
    private List<ProductItemVo> productItemVoList;
}
