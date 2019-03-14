package com.xlearn.sell.common;

import lombok.Getter;

/**
 * Description:商品是否在售状态枚举
 *
 * @author 轩辚
 * @date 2019/3/15 1:34
 */
@Getter
public enum ProductSaleStatusEnum {
    /**
     * 在售状态
     */
    UP(0,"在售"),
    /**
     * 下架状态
     */

    DOWN(1,"下架");
    /**
     * 状态编码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    ProductSaleStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
