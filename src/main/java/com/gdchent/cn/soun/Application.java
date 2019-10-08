package com.gdchent.cn.soun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gdchent
 * @date 2019/9/28 18:30
 * @description
 */

@ComponentScan
public class Application {


    public static void main(String ...args){

        //第一步 设置 ApplicationContext
        ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
        CDPlayer cdPlayer=context.getBean(CDPlayer.class);
        //调用播放方法
        cdPlayer.play();
    }
}
