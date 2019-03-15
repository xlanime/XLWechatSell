package com.xlearn.sell.common;

/**
 * Description:定义枚举类
 *
 * @author 轩辚
 * @date 2019/3/15 12:10
 */
public enum  ResponseCode {
    //声明枚举属性
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    //需要登录
    NEED_LOGIN(10,"NEED_LOGIN"),
    //参数错误
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    /**
     * 枚举类私有属性
     */
    private final int code;
    private final String desc;

    /**
     * 构造方法
     * @param code
     * @param desc
     */
    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取枚举类的对应属性
     * @return
     */
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }
}
