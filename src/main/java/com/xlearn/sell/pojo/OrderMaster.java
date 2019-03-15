package com.xlearn.sell.pojo;

import com.xlearn.sell.common.OrderStatusEnum;
import com.xlearn.sell.common.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:订单实体类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Data
public class OrderMaster {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认 0 新下单,1 已关闭订单，2 取消的订单
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态, 默认 0 未支付，1 已支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus, Date createTime, Date updateTime) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderMaster() {
        super();
    }
}