package com.gdchent.cn.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: gdchent
 * @date: 2019/10/8
 * @description:
 */
public class MainApplication {
    public static void main(String ...args){
        String config="fooBeans.xml";
        //同样的第一步还是拿到上下文对象
        ApplicationContext context=new ClassPathXmlApplicationContext(config);

        //获取Foo对象实例 通过反射
        Foo foo= (Foo) context.getBean("foo");
        foo.startInstallB();

        //获取Hidden对象实例
        HiddenBean hiddenBean= (HiddenBean) context.getBean("hiddenBean");
        System.out.println(hiddenBean);

    }
}
