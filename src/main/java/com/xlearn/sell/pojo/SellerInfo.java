package com.xlearn.sell.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:卖家信息实体类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Data
public class SellerInfo {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public SellerInfo(String id, String username, String password, String openid, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.openid = openid;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SellerInfo() {
        super();
    }
}