package com.xlearn.sell.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:订单详情实体类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Data
public class OrderDetail {
    /**
     * 订单详情ID
     */
    private String detailId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 当前商品价格,单位分
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private Integer productQuantity;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public OrderDetail(String detailId, String orderId, String productId, String productName, BigDecimal productPrice, Integer productQuantity, String productIcon, Date createTime, Date updateTime) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productIcon = productIcon;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderDetail() {
        super();
    }
}