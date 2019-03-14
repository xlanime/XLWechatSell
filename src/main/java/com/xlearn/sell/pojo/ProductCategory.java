package com.xlearn.sell.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:商品类目实体类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Data
public class ProductCategory {
    /**
     * 类目ID
     */
    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public ProductCategory(Integer categoryId, String categoryName, Integer categoryType, Date createTime, Date updateTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductCategory() {
        super();
    }
}