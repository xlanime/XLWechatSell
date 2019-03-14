package com.xlearn.sell.service.impl;

import com.xlearn.sell.dao.ProductCategoryMapper;
import com.xlearn.sell.pojo.ProductCategory;
import com.xlearn.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:商品类目接口实现
 *
 * @author 轩辚
 * @date 2019/3/14 23:49
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {
    /**
     * 注入productCategoryMapper
     */
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 新增
     *
     * @param productCategory 商品类目信息
     * @return 新增结果
     */
    @Override
    public int insert(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory);
    }

    /**
     * 根据主键删除
     *
     * @param id 商品类目Id
     * @return 删除结果
     */
    @Override
    public int deleteById(Integer id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param productCategory 需要更新的商品类目对象
     * @return 更新的结果
     */
    @Override
    public int update(ProductCategory productCategory) {
        return productCategoryMapper.updateByPrimaryKey(productCategory);
    }

    /**
     * 更新指定内容
     *
     * @param productCategory 需要更新的商品类目对象
     * @return 更新的结果
     */
    @Override
    public int updateSelective(ProductCategory productCategory) {
        return productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    /**
     * 根据主键查找
     *
     * @return 查询到的商品类目信息
     */
    @Override
    public ProductCategory findById(Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return 查询到的商品类目信息列表
     */
    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }
}
