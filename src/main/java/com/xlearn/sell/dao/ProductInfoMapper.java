package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:商品信息Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Mapper
@Component(value = "productInfoMapper")
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

    /**
     * 查找所有商品
     * @return 所有的商品
     */
    List<ProductInfo> findAll();

    /**
     * 根据销售状态查找商品
     * @param saleStatus 销售状态 0在售，1下架
     * @return 在售的商品列表
     */
    List<ProductInfo> findProductBySaleStatus(Integer saleStatus);
}