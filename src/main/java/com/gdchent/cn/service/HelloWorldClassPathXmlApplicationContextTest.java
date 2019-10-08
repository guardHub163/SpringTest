package com.gdchent.cn.service;

import com.sun.jndi.cosnaming.CNCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 使用FileSystemXmlApplicationContext这个类来读取xml文件配置  必须使用绝对路径
 */
public class HelloWorldClassPathXmlApplicationContextTest {

    public static void main(String ...args){

        // 第一步还是需要获取 上下问对象实例
        String config="HelloWorldBeans.xml"; //如果使用这种方式这里用的就是相对路径
        ApplicationContext context= new ClassPathXmlApplicationContext(config);//使用绝对路径
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld"); //可以通过xml的id来获取bean对象实例
        HelloWorld helloWorld2= (HelloWorld) context.getBean("helloWorld"); //这个是实例2

        //如果这2个是使用单例模式创建出来的  那么他们的内存地址 肯定是一样的
        System.out.println("h1:"+helloWorld);
        System.out.println(helloWorld2==helloWorld); //通过输出结果可以确定 默认是使用单例模式创建bean实例的
        //HelloWorld helloWorld=context.getBean(HelloWorld.class);
        System.out.println("输出message字段:"+helloWorld.getMessage());

    }
}
