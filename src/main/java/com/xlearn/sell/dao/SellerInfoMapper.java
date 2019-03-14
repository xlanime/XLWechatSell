package com.xlearn.sell.dao;

import com.xlearn.sell.pojo.SellerInfo;

/**
 * Description:卖家信息Mapper
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
public interface SellerInfoMapper {
    /**
     * 根据主键删除
     * @param id 卖家ID
     * @return 删除的结果
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增卖家信息
     * @param record 卖家实体类
     * @return 新增结果
     */
    int insert(SellerInfo record);

    /**
     * 新增卖家信息（插入指定数据）
     * @param record 卖家实体类
     * @return 新增结果
     */
    int insertSelective(SellerInfo record);

    /**
     * 根据主键查询
     * @param id 卖家ID
     * @return 查询的结果
     */
    SellerInfo selectByPrimaryKey(String id);

    /**
     * 根据主键修改（修改指定内容）
     * @param record 卖家实体类
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(SellerInfo record);

    /**
     * 根据主键修改
     * @param record 卖家实体类
     * @return 修改结果
     */
    int updateByPrimaryKey(SellerInfo record);
}