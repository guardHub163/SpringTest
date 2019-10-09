package com.gdchent.cn.ioc;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:简单实现ioc 底层原理
 */
public class MainApp {

    public static void main(String[] args) {
        String config="D:/software/SpringTest/src/main/resources/iocTestBeans.xml";
        ApplicationConext conext=new ClassPathXmlApplicationContext(config);

    }
}
