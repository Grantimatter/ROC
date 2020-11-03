package com.app;

import org.apache.log4j.Logger;

public class Service {
    private static Logger log = Logger.getLogger(Service.class);

    public static void main(String[] args) {
    }

    public void test(String test){
        log.info(test);
    }
}
