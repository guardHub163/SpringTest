package com.gdchent.cn.scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        String config="exampleBean.xml";
        AbstractApplicationContext context=new ClassPathXmlApplicationContext(config);
        ExampleBean exampleBean=context.getBean(ExampleBean.class);
        context.registerShutdownHook(); //自动帮你销毁方法

    }
}
