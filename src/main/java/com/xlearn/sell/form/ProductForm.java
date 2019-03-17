package com.xlearn.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:表单传递到后端的商品信息对象
 *
 * @author 轩辚
 * @date 2019/3/16 20:58
 */
@Data
public class ProductForm {

    /** 商品id */
    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;
}
