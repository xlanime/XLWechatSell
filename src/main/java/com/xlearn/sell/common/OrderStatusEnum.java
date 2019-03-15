package com.xlearn.sell.common;

import lombok.Getter;

/**
 * Description:订单状态枚举
 *
 * @author 轩辚
 * @date 2019/3/15 1:34
 */
@Getter
public enum OrderStatusEnum {
    /**
     * 新订单
     */
    NEW(0,"新订单"),
    /**
     * 完成的订单
     */
    FINISHED(1,"完成的订单"),
    /**
     * 取消的订单
      */
    CANCEL(2,"取消的订单");

    /**
     * 状态编码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
