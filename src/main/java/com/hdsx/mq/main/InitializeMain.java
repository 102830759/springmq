package com.hdsx.mq.main;


import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 * Created by admin on 2017/1/10.
 */
public class InitializeMain {

    public InitializeMain(String url) throws IOException {
    }

    public static void main(String[] agrs) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
