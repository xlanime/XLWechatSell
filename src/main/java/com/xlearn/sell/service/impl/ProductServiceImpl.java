package com.xlearn.sell.service.impl;

import com.xlearn.sell.dao.ProductInfoMapper;
import com.xlearn.sell.pojo.ProductInfo;
import com.xlearn.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/14 23:50
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    /**
     * 注入productInfoMapper
     */
    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 新增
     *
     * @param productInfo 商品信息
     * @return 新增结果
     */
    @Override
    public int insert(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    /**
     * 根据主键删除
     *
     * @param id 商品Id
     * @return 删除结果
     */
    @Override
    public int deleteById(String id) {
        return productInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param productInfo 需要更新的商品对象
     * @return 更新的结果
     */
    @Override
    public int update(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKey(productInfo);
    }

    /**
     * 更新指定内容
     *
     * @param productInfo 需要更新的商品对象
     * @return 更新的结果
     */
    @Override
    public int updateSelective(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    /**
     * 根据主键查找
     *
     * @param id 商品id
     * @return 查询到的商品信息
     */
    @Override
    public ProductInfo findById(String id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return 查询到的商品信息列表
     */
    @Override
    public List<ProductInfo> findAll(Integer page,Integer limit) {
        return productInfoMapper.findAll();
    }

    /**
     * 根据是否下架查询商品信息
     * @param page 页码
     * @param limit 每页数据条数
     * @param saleStatus 商品是否下架，0在售，1下架
     * @return
     */
    @Override
    public List<ProductInfo> findBySaleStatus(Integer page,Integer limit,Integer saleStatus) {
        return productInfoMapper.findProductBySaleStatus(saleStatus);
    }
}
