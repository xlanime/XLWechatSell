package com.xlearn.sell.service.impl;

import com.xlearn.sell.dao.SellerInfoMapper;
import com.xlearn.sell.pojo.SellerInfo;
import com.xlearn.sell.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:卖家信息接口实现
 *
 * @author 轩辚
 * @date 2019/3/14 23:19
 */
@Service("sellerService")
@Slf4j
public class SellerServiceImpl implements SellerService {

    /**
     * 注入sellerInfoMapper
     */
    @Autowired
    private SellerInfoMapper sellerInfoMapper;

    /**
     * 新增
     *
     * @param sellerInfo 卖家信息
     * @return 新增结果
     */
    @Override
    public int insert(SellerInfo sellerInfo) {
        return sellerInfoMapper.insert(sellerInfo);
    }

    /**
     * 根据主键删除
     *
     * @param id 卖家Id
     * @return 删除结果
     */
    @Override
    public int deleteById(String id) {
        return sellerInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param sellerInfo 需要更新的卖家对象
     * @return 更新的结果
     */
    @Override
    public int update(SellerInfo sellerInfo) {
        return sellerInfoMapper.updateByPrimaryKey(sellerInfo);
    }

    /**
     * 更新指定内容
     *
     * @param sellerInfo 需要更新的卖家对象
     * @return 更新的结果
     */
    @Override
    public int updateSelective(SellerInfo sellerInfo) {
        return sellerInfoMapper.updateByPrimaryKeySelective(sellerInfo);
    }

    /**
     * 根据主键查找
     *
     * @param id 卖家id
     * @return 查询到的卖家信息
     */
    @Override
    public SellerInfo findById(String id) {
        return sellerInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return 查询到的卖家信息列表
     */
    @Override
    public List<SellerInfo> findAll() {
        return sellerInfoMapper.findAll();
    }
}
