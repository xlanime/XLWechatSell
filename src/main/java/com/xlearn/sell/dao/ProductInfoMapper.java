package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.ProductInfo;

/**
 * Description:商品信息Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
public interface ProductInfoMapper {
    /**
     * 根据主键删除
     * @param productId 商品ID
     * @return 删除的结果
     */
    int deleteByPrimaryKey(String productId);

    /**
     * 新增商品信息
     * @param record 商品实体类
     * @return 新增结果
     */
    int insert(ProductInfo record);

    /**
     * 新增商品信息（插入指定数据）
     * @param record 商品实体类
     * @return 新增结果
     */
    int insertSelective(ProductInfo record);

    /**
     * 根据主键查询
     * @param productId 商品ID
     * @return 查询的结果
     */
    ProductInfo selectByPrimaryKey(String productId);

    /**
     * 根据主键修改（修改指定内容）
     * @param record 商品实体类
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(ProductInfo record);

    /**
     * 根据主键修改
     * @param record 商品实体类
     * @return 修改结果
     */
    int updateByPrimaryKey(ProductInfo record);
}