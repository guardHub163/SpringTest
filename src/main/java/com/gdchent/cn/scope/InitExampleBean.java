package com.gdchent.cn.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 这个类的2个回调方法会在xml的bean标签指定的初始化方法调用之前后调用之后分别调用
 */
public class InitExampleBean implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beforeInitialization:"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("afterInitialization:"+beanName);
        return bean;
    }

}
