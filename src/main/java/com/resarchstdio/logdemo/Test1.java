package com.resarchstdio.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Malei on 16/1/26.
 */

/**
 * 使用log4j记录日志的时候,需要意识到log4j写日志的过程本来就有对系统的损耗
 */
public class Test1 {

    public static Logger logger = LoggerFactory.getLogger(Test1.class);

    public static void bad(){
       logger.debug("this is a debug user id is " + 100 + "orderid is " + 123123);
    }
    // 防止没有必要的拼接字符串
    // 另外 在代码上线的时候,要先习惯性的减少debug语句的数量
    public static void good(){
        if (logger.isDebugEnabled()){
            logger.debug("this is a debug user id is " + 100 + "orderid is " + 123123);
        }
    }

    public static void main(String[] args) {

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            bad();
        }
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            good();
        }
        long l3 = System.currentTimeMillis();
        System.out.println("100000 bad    cost " + (l2 -l1)+ "mills");
        System.out.println("100000 good   cost " + (l3 -l2)+ "mills");
    }
}
