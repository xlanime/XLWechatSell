package com.xlearn.sell.exception;

import com.xlearn.sell.common.ResultEnum;

/**
 * Description:自定义异常
 *
 * @author 轩辚
 * @date 2019/3/15 18:46
 */
public class SellException extends RuntimeException{
    /**
     * 异常编码
     */
    private Integer code;

    /**
     * 构造方法，构造自定义异常
     * @param resultEnum 异常信息的枚举
     */
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer errorCode,String errorMsg){
        super(errorMsg);
        this.code = errorCode;
    }

}
