package com.gdchent.cn.ioc;

import com.gdchent.cn.service.Student;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:简单实现ioc 底层原理
 */
public class MainApplication {

    public static void main(String[] args) {
        String config="D:/software/SpringTest/src/main/resources/iocTestBeans.xml";
        ApplicationConext conext=new ClassPathXmlApplicationContext(config);
        Student student = (Student) conext.getBean("student");
        System.out.println("获取实例对象"+student);
        Student student2 = (Student) conext.getBean(Student.class);
        System.out.println("获取实例对象2:"+student2);
    }
}
