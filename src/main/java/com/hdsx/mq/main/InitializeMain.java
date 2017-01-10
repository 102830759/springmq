package com.hdsx.mq.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by admin on 2017/1/10.
 */
public class InitializeMain {

    public InitializeMain(String url) throws IOException {
        /*Properties pro = new Properties();
        FileInputStream in = new FileInputStream("/application.properties");
        pro.load(in);
        // 获取
        // 设置
        pro.setProperty("MQUrl", url);
        String key = pro.getProperty("MQUrl");*/
        System.out.println(url);
    }

    public static void main(String[] agrs) throws IOException {
        InitializeMain initializeMain = new InitializeMain("127.0.0.1:8080");
    }
}
