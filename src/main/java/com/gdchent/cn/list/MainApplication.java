package com.gdchent.cn.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description: 注入一个带List Set Map
 */
public class MainApplication {
    public static void main(String... args) {
        //第一步获取配置文件
        String config = "collectBeans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //通过getBean方法获取bean对象实例
        JavaCollection javaCollection = (JavaCollection) context.getBean("javaCollection");
        //第三步操作
        List list = javaCollection.getAddressList();
        Set set = javaCollection.getAddressSet();
        Map map = javaCollection.getAddressMap();
        Properties properties = javaCollection.getAddressProp();
        Iterator iterator = list.iterator();
        Iterator setIt = set.iterator();
        Iterator mapIt = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Object t = iterator.next();
            if (t instanceof String) {
                String address = (String) t;
                System.out.println("输出地址:" + address);
            }
        }
        System.out.println("=========遍历输出Set集合===========================");
        while (setIt.hasNext()) {
            Object t = setIt.next();
            if (t instanceof String) {
                String address = (String) t;
                System.out.println("输出地址:" + address);
            }
        }
        System.out.println("=========遍历输出Map集合===========================");
        while (mapIt.hasNext()) {
            Map.Entry entry = (Map.Entry) mapIt.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("map输出地址:" + ",key=" + key + ",value=" + value);
        }
        System.out.println("========================Properties方式===========================");
        String one=properties.getProperty("one");
        System.out.println("one:"+one);
        String two=properties.getProperty("two");
        System.out.println("two:"+two);
        String three=properties.getProperty("three");
        System.out.println("three:"+three);
        String four=properties.getProperty("four");
        System.out.println("four:"+four);
    }
}
