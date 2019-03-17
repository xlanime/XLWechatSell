package com.xlearn.sell.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xlearn.sell.form.OrderForm;
import com.xlearn.sell.pojo.OrderMaster;
import com.xlearn.sell.vo.OrderInfoVo;
import com.xlearn.sell.vo.ProductItemVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:OrderForm转换为OrderInfoVo的转换器
 *  支持将OrderForm转换为OrderInfoVo
 *  或将List<OrderForm>转换为List<OrderInfoVo>
 *
 * @author 轩辚
 * @date 2019/3/16 0:53
 */
public class OrderForm2OrderInfoVoConverter {
    /**
     * 将orderForm转换为OrderInfoVo
     * @param orderForm 需要转换的orderForm对象
     * @return 转换结果
     */
    public static OrderInfoVo convert(OrderForm orderForm){
        //直接取出orderForm属性赋值给OrderInfo
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setBuyerName(orderForm.getName());
        orderInfoVo.setBuyerPhone(orderForm.getPhone());
        orderInfoVo.setBuyerOpenid(orderForm.getOpenid());
        orderInfoVo.setBuyerAddress(orderForm.getAddress());
        //订单详情以JSON字符串的格式存放在orderForm的items属性
        String orderDetailString = orderForm.getItems();
//        JSONArray orderDetailArray = JSON.parseArray(orderDetailString);
        //遍历JSONArray，将数据转换为List<ProductItemVo>
        List<ProductItemVo> productItemVoList = JSON.parseArray(orderDetailString,ProductItemVo.class);
//        for(int i = 0;i<orderDetailArray.size();i++){
//            JSONObject productItemJson = orderDetailArray.getJSONObject(i);
//            ProductItemVo productItemVo = new ProductItemVo();
//            productItemVo.setProductQuantity((Integer) productItemJson.get("productQuantity"));
//            productItemVo.setProductId((String)productItemJson.get("productQuantity"));
//            productItemVoList.add(productItemVo);
//        }
        orderInfoVo.setProductItemVoList(productItemVoList);
        return orderInfoVo;
    }

    /**
     * 将List<OrderForm>转换为List<OrderInfoVo>
     * @param orderFormList 需要转换的OrderForm列表
     * @return 转换结果
     */
    public static List<OrderInfoVo> convert(List<OrderForm> orderFormList){
        //List转换需要逐个转换
        List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
        for(OrderForm orderForm : orderFormList){
            OrderInfoVo orderInfoVo = convert(orderForm);
            orderInfoVoList.add(orderInfoVo);
        }
        return orderInfoVoList;
    }
}
