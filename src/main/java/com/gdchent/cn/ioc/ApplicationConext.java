package com.gdchent.cn.ioc;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
public interface ApplicationConext {

    Object getBean(String path);

    Object getBean(Class requiredType);

}
