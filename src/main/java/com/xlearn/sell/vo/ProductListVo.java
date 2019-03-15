package com.xlearn.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:返回给前端的商品信息列表
 *
 * @author 轩辚
 * @date 2019/3/15 12:15
 */
@Data
public class ProductListVo {
    /**
     * 类目名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;

    /**
     * 商品信息列表
     */
    @JsonProperty("foods")
    private List<ProductInfoVo> productVoList;

}
