package com.gdchent.cn.soun;

import org.springframework.stereotype.Component;

/**
 * @author gdchent
 * @date 2019/9/28 18:19
 * @description
 */

@Component   //这个注解用来创建java的bean的实例
public class CompactDisc {


    public CompactDisc() {
        super();
        System.out.println("CompactDisc无参数构造器调用");
    }

    public void play(){
        System.out.println("CompactDisc调用播放方法，正在播放音乐");
    }

}
