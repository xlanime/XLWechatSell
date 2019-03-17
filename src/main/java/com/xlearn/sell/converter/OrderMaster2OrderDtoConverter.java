package com.xlearn.sell.converter;

import com.xlearn.sell.dto.OrderDto;
import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.vo.OrderInfoVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:OrderMaster转换为OrderDto的转换器
 *  支持将OrderMaster转换为OrderDto
 *  或将List<OrderMaster>转换为List<OrderDto>
 *
 * @author 轩辚
 * @date 2019/3/16 0:53
 */
public class OrderMaster2OrderDtoConverter {
    /**
     * 将OrderMaster转换为OrderDto
     * @param orderMaster 需要转换的orderMaster对象
     * @return 转换结果
     */
    public static OrderDto convert(OrderMaster orderMaster){
        //对象转换比较简单，直接使用BeanUtils复制属性即可
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;
    }

    /**
     * 将List<OrderMaster>转换为List<OrderDto>
     * @param orderMasterList 需要转换的orderMaster列表
     * @return 转换结果
     */
    public static List<OrderDto> convert(List<OrderMaster> orderMasterList){
        //List转换需要逐个转换
        List<OrderDto> orderDtoList = new ArrayList<>();
        for(OrderMaster orderMaster : orderMasterList){
            OrderDto orderDto = convert(orderMaster);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}
