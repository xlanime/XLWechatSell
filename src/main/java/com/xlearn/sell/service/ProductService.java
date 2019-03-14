package com.xlearn.sell.service;

import com.xlearn.sell.pojo.ProductInfo;

import java.util.List;

/**
 * Description:商品信息接口
 *
 * @author 轩辚
 * @date 2019/3/14 23:41
 */
public interface ProductService {
    /**
     * 新增
     * @param productInfo 商品信息
     * @return 新增结果
     */
    int insert(ProductInfo productInfo);

    /**
     * 根据主键删除
     * @param id 商品Id
     * @return 删除结果
     */
    int deleteById(String id);

    /**
     * 更新
     * @param productInfo 需要更新的商品对象
     * @return 更新的结果
     */
    int update(ProductInfo productInfo);

    /**
     * 更新指定内容
     * @param productInfo 需要更新的商品对象
     * @return 更新的结果
     */
    int updateSelective(ProductInfo productInfo);

    /**
     * 根据主键查找
     * @param id 商品id
     * @return 查询到的商品信息
     */
    ProductInfo findById(String id);

    /**
     * 查询所有
     * @param page 页码
     * @param limit 每页数据条数
     * @return 查询到的商品信息列表
     */
    List<ProductInfo> findAll(Integer page,Integer limit);

    /**
     * 根据是否下架查询商品信息
     * @param page 页码
     * @param limit 每页数据条数
     * @param saleStatus 商品是否下架，0在售，1下架
     * @return
     */
    List<ProductInfo> findBySaleStatus(Integer page,Integer limit,Integer saleStatus);
}
