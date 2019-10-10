package com.gdchent.cn.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */
public class MainApplication {
    public static void main(String[] args) {
//        Car car=StaticCarFactory.getCar(1L);
//        System.out.println(car);
        String config="springFactory.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        Car car= (Car) context.getBean("car");
        System.out.println(car);
        //实例化工厂
        InstanceFactory instanceFactory=new InstanceFactory();
        Car c=instanceFactory.getCar(1L);
        System.out.println("c:"+c);
    }
}
