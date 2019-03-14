package com.xlearn.sell.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:商品信息实体类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Data
public class ProductInfo {
    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType, Date createTime, Date updateTime) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductInfo() {
        super();
    }
}