package com.gdchent.cn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 使用FileSystemXmlApplicationContext这个类来读取xml文件配置  必须使用绝对路径
 */
public class HelloWorldFileSystemXmlApplicationContextTest {

    public static void main(String ...args){

        // 第一步还是需要获取 上下问对象实例
        String config="D:/software/SpringTest/src/main/resources/HelloWorldBeans.xml";
        ApplicationContext context= new FileSystemXmlApplicationContext(config);//使用绝对路径
        //HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld"); //可以通过xml的id来获取bean对象实例
        HelloWorld helloWorld=context.getBean(HelloWorld.class);
        System.out.println("输出message字段:"+helloWorld.getMessage());
    }
}
