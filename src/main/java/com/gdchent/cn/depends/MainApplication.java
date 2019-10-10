package com.gdchent.cn.depends;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */
public class MainApplication {

    public static void main(String ...args){
        String config="springDepends.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);

    }
}
