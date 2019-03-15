package com.xlearn.sell.utils;

import java.util.UUID;

/**
 * Description:获取UUID的工具类
 *
 * @author 轩辚
 * @date 2019/3/15 23:26
 */
public class UUIDUtil {

    /**
     * 获取36位的UUID
     * @return 36位的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取32位的UUID
     * @return 32位的UUID
     */
    public static String getShortUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
