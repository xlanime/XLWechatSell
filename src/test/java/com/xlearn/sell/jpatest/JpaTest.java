package com.xlearn.sell.jpatest;

import com.xlearn.sell.repository.SellerInfo;
import com.xlearn.sell.repository.SellerInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * Description:Jpa测试类
 *
 * @author 轩辚
 * @date 2019/3/14 22:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    /**
     * 获取卖家信息
     */
    @Test
    public void getSellerInfo(){
        List<SellerInfo> sellerInfoList = sellerInfoRepository.findAll();
        for (SellerInfo sellerInfoItem : sellerInfoList){
            System.out.println(sellerInfoItem.toString());
        }
    }

    /**
     * 修改卖家信息
     */
    @Test
    public void updateSellerInfo(){
        SellerInfo sellerInfo = sellerInfoRepository.findById("1");
        sellerInfo.setUsername("谢轩辚");
        sellerInfoRepository.save(sellerInfo);
    }
}
