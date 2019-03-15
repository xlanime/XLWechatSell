package com.xlearn.sell.service.impl;

import com.xlearn.sell.common.ResultEnum;
import com.xlearn.sell.dao.ProductInfoMapper;
import com.xlearn.sell.exception.SellException;
import com.xlearn.sell.pojo.ProductInfo;
import com.xlearn.sell.service.ProductService;
import com.xlearn.sell.vo.ProductItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<ProductInfo> findAll() {
        return productInfoMapper.findAll();
    }

    /**
     * 根据是否下架查询商品信息
     * @param saleStatus 商品是否下架，0在售，1下架
     * @return
     */
    @Override
    public List<ProductInfo> findBySaleStatus(Integer saleStatus) {
        return productInfoMapper.findProductBySaleStatus(saleStatus);
    }

    /**
     * 增加库存
     *
     * @param productItemVoList 增加库存的商品信息（ID及增加的数量）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<ProductItemVo> productItemVoList) {
        for(ProductItemVo productItemVo : productItemVoList) {
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productItemVo.getProductId());
            if(null == productInfo){
                //商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //增加后的库存
            int stock = productInfo.getProductStock() + productItemVo.getProductQuantity();
            //保存数据到数据库
            productInfo.setProductStock(stock);
            productInfoMapper.updateByPrimaryKey(productInfo);
        }
    }

    /**
     * 扣减库存
     *
     * @param productItemVoList 扣减库存的商品信息（ID及减少的数量）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<ProductItemVo> productItemVoList) {
        for(ProductItemVo productItemVo : productItemVoList) {
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productItemVo.getProductId());
            if(null == productInfo){
                //商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //扣减后的库存如果小于0，认为库存不足，抛出异常并回滚事务
            int stock = productInfo.getProductStock() - productItemVo.getProductQuantity();
            if(stock < 0){
                throw new SellException(ResultEnum.PRODUCT_LOW_STOCK);
            }
            //库存充足则进行扣减，并保存
            productInfo.setProductStock(stock);
            productInfoMapper.updateByPrimaryKey(productInfo);
        }
    }
}
