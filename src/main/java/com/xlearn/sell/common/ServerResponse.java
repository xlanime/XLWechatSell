package com.xlearn.sell.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Description:可复用的返回对象
 * 继承Serializable使之可以序列化成Json
 * 使用@JsonSerialize注解，避免序列化的时候存在空的key
 *
 * @author 轩辚
 * @date 2019/3/15 12:10
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    /**
     * 声明私有属性
     */
    private int code;
    private String msg;
    private T data;

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    public T getData(){
        return this.data;
    }

    /**
     * 私有化构造函数,共有四种构造函数。code是都会有的。然后msg和data可能有。
     * 所以共四种
     */
    private ServerResponse(int code){
        this.code = code;
    }

    private ServerResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(int code,T data){
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功的时候不同情况下的public方法，供外部调用
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    /**
     * 失败的时候不同情况下的public方法，供外部调用。失败的时候不会有data，所以只需要写三个
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String msg){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(Integer code,String msg){
        return new ServerResponse(code,msg);
    }
}
