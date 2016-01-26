package com.resarchstdio.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
class Bar {
 
    public static Logger logger = LoggerFactory.getLogger(Bar.class);
 
    public static void doIt() {
        logger.error("doing my job");
        logger.error("this is my error {} is userid ", 123, new RuntimeException("cacaca"));
    }

    public static void main(String[] args) {
       doIt();
    }
}