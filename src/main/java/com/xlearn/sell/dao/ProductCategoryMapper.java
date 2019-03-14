package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:商品类目Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Mapper
@Component(value = "productCategoryMapper")
public interface ProductCategoryMapper {
    /**
     * 根据主键删除
     * @param categoryId 类目ID
     * @return 删除的结果
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * 新增商品类目信息
     * @param record 商品类目实体类
     * @return 新增结果
     */
    int insert(ProductCategory record);

    /**
     * 新增商品类目信息（插入指定数据）
     * @param record 商品类目实体类
     * @return 新增结果
     */
    int insertSelective(ProductCategory record);

    /**
     * 根据主键查询
     * @param categoryId 商品类目ID
     * @return 查询的结果
     */
    ProductCategory selectByPrimaryKey(Integer categoryId);

    /**
     * 根据主键修改（修改指定内容）
     * @param record 商品类目实体类
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(ProductCategory record);

    /**
     * 根据主键修改
     * @param record 商品类目实体类
     * @return 修改结果
     */
    int updateByPrimaryKey(ProductCategory record);

    /**
     * 查询所有商品类目
     * @return 所有商品类目
     */
    List<ProductCategory> findAll();
}