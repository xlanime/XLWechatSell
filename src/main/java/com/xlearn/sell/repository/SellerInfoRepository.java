package com.xlearn.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:JPA实现卖家信息操作
 *
 * @author 轩辚
 * @date 2019/3/14 21:51
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,Integer> {

    /**
     * 根据主键查询
     * @param id 卖家Id
     * @return 查询到的Id
     */
    SellerInfo findById(String id);
}
