package com.xlearn.sell.common;

import lombok.Getter;

/**
 * Description:查询结果枚举
 *
 * @author 轩辚
 * @date 2019/3/15 1:34
 */
@Getter
public enum ResultEnum {
    /** 商品不存在 */
    PRODUCT_NOT_EXIST(100,"商品不存在"),
    /** 商品库存不足 */
    PRODUCT_LOW_STOCK(101,"商品库存不足"),
    /** 订单不存在 */
    ORDER_NOT_EXIST(102,"订单不存在"),
    /** 订单详情不存在 */
    ORDER_DETAIL_NOT_EXIST(103,"订单详情不存在"),
    /** 订单不支持取消 */
    ORDER_CAN_NOT_CANCEL(104,"订单不支持取消"),
    /** 订单状态更新失败 */
    ORDER_UPDATE_FAIL(105,"订单状态更新失败"),
    ;

    /**
     * 状态编码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
