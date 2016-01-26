package com.resarchstdio.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Malei on 16/1/26.
 */

/**
 * 在系
 */
public class Test4 {

    public static Logger logger = LoggerFactory.getLogger(Test4.class);

    public static void bad(){
       logger.info("this is a debug user id is " + 100 + "orderid is " + 123123);
    }

    // 使用slf4j 占位符来处理
    public static void better(){
        logger.info("this is a debug user id is {} orderrid is {}", 100, 123123);
    }

    public static void main(String[] args) {

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            bad();
        }
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            better();
        }
        long l4 = System.currentTimeMillis();
        System.out.println("100000 bad    cost " + (l3 -l1)+ "mills");
        System.out.println("100000 better cost " + (l4 -l3)+ "mills");
    }
}
