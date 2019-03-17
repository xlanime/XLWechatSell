package com.xlearn.sell.converter;

import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.vo.OrderInfoVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:OrderMaster转换为OrderInfoVo的转换器
 *  支持将OrderMaster转换为OrderInfoVo
 *  或将List<OrderMaster>转换为List<OrderInfoVo>
 *
 * @author 轩辚
 * @date 2019/3/16 0:53
 */
public class OrderMaster2OrderInfoVoConverter {
    /**
     * 将OrderMaster转换为OrderInfoVo
     * @param orderMaster 需要转换的orderMaster对象
     * @return 转换结果
     */
    public static OrderInfoVo convert(OrderMaster orderMaster){
        //对象转换比较简单，直接使用BeanUtils复制属性即可
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        BeanUtils.copyProperties(orderMaster,orderInfoVo);
        return orderInfoVo;
    }

    /**
     * 将List<OrderMaster>转换为List<OrderInfoVo>
     * @param orderMasterList 需要转换的orderMaster列表
     * @return 转换结果
     */
    public static List<OrderInfoVo> convert(List<OrderMaster> orderMasterList){
        //List转换需要逐个转换
        List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
        for(OrderMaster orderMaster : orderMasterList){
            OrderInfoVo orderInfoVo = convert(orderMaster);
            orderInfoVoList.add(orderInfoVo);
        }
        return orderInfoVoList;
    }
}
