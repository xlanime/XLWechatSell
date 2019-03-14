package com.xlearn.sell.basetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 *  Logback日志测试类
 *
 * @author 轩辚
 * @date 2019/3/14 18:27
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoggerTest {

    @Test
    public void loggerLevelTest(){
        log.trace(" -- trace");
        log.debug(" -- debug");
        log.info(" -- info");
        log.warn(" -- warn");
        log.error(" -- error");
    }

    @Test
    public void loggerValueTest(){
        String name = "Richard";
        String password = "wozai80";
        //{}是占位符
        log.info("name is {},password is {}",name,password);
    }
}
