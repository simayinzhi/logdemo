package com.resarchstdio.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Malei on 16/1/26.
 */

/**
 * 使用log4j记录日志的时候,需要意识到log4j写日志的过程本来就有对系统的损耗
 */
public class Test3 {


    public static void main(String[] args) {
        MyThread myThread = new MyThread(123);
        myThread.start();
    }
}
class MyThread extends Thread{

    private static Logger logger = LoggerFactory.getLogger(MyThread.class);
    private int id;

    public MyThread(int count) {
        this.id = count;
    }

    // 写有意义的log 将关键信息写入log中,便于找到问题
    public void run() {
        logger.info("PROCESS {} START", id);
        try {
            this.throwError();
            logger.info("PROCESS {} SUCCESS", id);
        } catch (Exception e) {
            logger.error("PROCESS {} FAILED", id, e);
        }
    }

    /**
     * 爆出的异常尽量要简单并且有价值
     * @throws Exception
     */
    private void throwError() throws Exception{
        throw new Exception(String.format("alibaba interface throw exception while process %d", id));
    }
}
