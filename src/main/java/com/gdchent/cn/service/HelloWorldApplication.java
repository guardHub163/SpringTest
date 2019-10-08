package com.gdchent.cn.service;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 需求：测试 从xml配置文件 读取Java的bean实例
 */
public class HelloWorldApplication {

    public static void main(String ...args){

        // 第一步从配置文件 读取xml文件信息
        ClassPathResource classPathResource=new ClassPathResource("HelloWorldBeans.xml");
        //第一步  读取xml文件信息
        XmlBeanFactory factory=new XmlBeanFactory(classPathResource);
        //获取bean实例之后
        HelloWorld helloWorld=factory.getBean(HelloWorld.class);
        System.out.println("get:"+helloWorld.getMessage());
    }
}
