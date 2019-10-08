package com.gdchent.cn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Spring ApplicationContext 容器 它是一个接口
 * 通常它的接口实现 有3个类
 * FileSystemXmlApplicationContext 该容器从xml文件中加载已经被定义的bean。需要提供给给构造器xml文件的完整路径
 */
public class FileSystemXmlApplicationContextTest {


    public static void main(String ...args){

        //第一步获取ApplicationContext容器实例
        //String config="applicationContext.xml";
        String config="D:/software/SpringTest/src/main/resources/applicationContext.xml";
        //读取配置文件 如果这里你使用FileSystemXmlApplication这个API 那么你就要在它的构造器使用绝对路径
        ApplicationContext context=new FileSystemXmlApplicationContext(config);//运行就是直接报错 找不到资源

        MessagePrinter messagePrinter=context.getBean(MessagePrinter.class);//读取打印机实体类
        // 要用这个容器来创建我所需要的Javabean的实例
        MessageService messageService=context.getBean(MessageService.class);
        messagePrinter.setMessageService(messageService);
        messagePrinter.printMessage();
    }
}
