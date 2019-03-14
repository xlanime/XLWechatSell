package com.xlearn.sell.service;

import com.xlearn.sell.pojo.ProductCategory;

import java.util.List;

/**
 * Description:商品类目接口
 *
 * @author 轩辚
 * @date 2019/3/14 23:46
 */
public interface ProductCategoryService {
    /**
     * 新增
     * @param productCategory 商品类目信息
     * @return 新增结果
     */
    int insert(ProductCategory productCategory);

    /**
     * 根据主键删除
     * @param id 商品类目Id
     * @return 删除结果
     */
    int deleteById(Integer id);

    /**
     * 更新
     * @param productCategory 需要更新的商品类目对象
     * @return 更新的结果
     */
    int update(ProductCategory productCategory);

    /**
     * 更新指定内容
     * @param productCategory 需要更新的商品类目对象
     * @return 更新的结果
     */
    int updateSelective(ProductCategory productCategory);

    /**
     * 根据主键查找
     * @param id 商品类目id
     * @return 查询到的商品类目信息
     */
    ProductCategory findById(Integer id);

    /**
     * 查询所有
     * @return 查询到的商品类目信息列表
     */
    List<ProductCategory> findAll();
}
