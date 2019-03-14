package com.xlearn.sell.service;

import com.xlearn.sell.pojo.SellerInfo;

import java.util.List;

/**
 * Description:卖家信息接口
 *
 * @author 轩辚
 * @date 2019/3/14 23:18
 */
public interface SellerService {
    /**
     * 新增
     * @param sellerInfo 卖家信息
     * @return 新增结果
     */
    int insert(SellerInfo sellerInfo);

    /**
     * 根据主键删除
     * @param id 卖家Id
     * @return 删除结果
     */
    int deleteById(String id);

    /**
     * 更新
     * @param sellerInfo 需要更新的卖家对象
     * @return 更新的结果
     */
    int update(SellerInfo sellerInfo);

    /**
     * 更新指定内容
     * @param sellerInfo 需要更新的卖家对象
     * @return 更新的结果
     */
    int updateSelective(SellerInfo sellerInfo);

    /**
     * 根据主键查找
     * @param id 卖家id
     * @return 查询到的卖家信息
     */
    SellerInfo findById(String id);

    /**
     * 查询所有
     * @return 查询到的卖家信息列表
     */
    List<SellerInfo> findAll();
}
