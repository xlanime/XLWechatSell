package com.xlearn.sell.common;

import lombok.Getter;

/**
 * Description:支付状态枚举
 *
 * @author 轩辚
 * @date 2019/3/15 1:34
 */
@Getter
public enum PayStatusEnum {
    /**
     * 等待支付
     */
    WAIT(0,"等待支付"),
    /**
     * 支付完成
     */
    SUCCESS(1,"支付完成");

    /**
     * 状态编码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
