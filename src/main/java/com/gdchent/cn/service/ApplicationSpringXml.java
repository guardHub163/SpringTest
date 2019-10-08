package com.gdchent.cn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过xml配置文件 获取bean对象的属性 ，因为这个spring的xml文件绑定bean对象关联了
 */
public class ApplicationSpringXml {

    public static void main(String... args) {

        //第一步获取ApplicationContext容器实例
        String config="applicationContext.xml";

        //ApplicationContext是一个接口 它有3个
        //ClassPathXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取bean对象
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);

        MessageService messageService=context.getBean(MessageService.class);
        messagePrinter.setMessageService(messageService);
        //调用printer对象  测试
        messagePrinter.printMessage(); //打印消息
        //获取someService实例 生成一个接口的实现实例
        SomeService someService= (SomeService) context.getBean("someServiceBean");
        // SomeService someService=context.getBean(SomeServiceImpl.class);
        someService.doSome();


    }
}
