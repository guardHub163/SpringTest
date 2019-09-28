package com.gdchent.cn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("应用程序application_start");
        //创建打印机对象
        MessagePrinter messagePrinter=new MessagePrinter();
        //创建消息服务对象
        MessageService messageService=new MessageService();
        //设置service
        messagePrinter.setMessageService(messageService);
        //打印消息
        messagePrinter.printMessage();

//        Student student=new Student();
//        student.getName();
//        student.setName("wangwu");
//        System.out.println(student);

        String config="spring.xml";
        //加载配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        Student student= (Student) context.getBean("student");//这个getBean的参数就是在spring.xml里面的bean标签的id的值

        //因为xml里面给该bean已经进行了赋值
        System.out.println(student.getName());
    }
}
