package com.gdchent.cn.parent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:测试spring的继承 parent 2个xml的bean具有一样的属性 直接继承过来 非Java那样的继承
 */
public class MainApplication {

    public static void main(String ...args){
        String config="parentBeans.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        Parent parent1= (Parent) context.getBean("parent1");
        Parent parent2= (Parent) context.getBean("parent2");
        System.out.println("name1:"+parent1.getName());//name1:gdchent
        System.out.println("name2:"+parent2.getName()); //name1:gdchent
        System.out.println(parent1==parent2); //false
    }
}
