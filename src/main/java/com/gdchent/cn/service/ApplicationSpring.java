package com.gdchent.cn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 通过spring框架来测试 创建实例的过程
 */

@ComponentScan //扫描所有有Component的实例
public class ApplicationSpring {

    public static void main(String ...args){
        System.out.println("SpringApplication开始");
        //通过注解 省去了我们自动创建对象的过程
        ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationSpring.class);
        //第一步 从容器中获取MessagePrinter对象
        MessagePrinter messagePrinter=context.getBean(MessagePrinter.class);
        //因为MessagePrinter对象里面包含有MessagerService实例 所以也是需要容器进行创建的
        MessageService messageService=context.getBean(MessageService.class);
        messageService.setMessage("hello world");
        //设置对象的属性
        messagePrinter.setMessageService(messageService);
        messagePrinter.printMessage();
        System.out.println("end up");
    }
}
