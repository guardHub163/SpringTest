package com.gdchent.cn.soun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gdchent
 * @date 2019/9/28 18:19
 * @description
 */

@Component   //这里同理也是在Java的构造器里面创建Java的实例
public class CDPlayer {

    private CompactDisc compactDisc;

    public CDPlayer() {
        super();
        System.out.println("CD播放器无参构造器");
    }

    @Autowired  //这个注解自动装配， 自动创建CompactDisc参数实例
    public CDPlayer(CompactDisc compactDisc) {
        super();
        this.compactDisc = compactDisc;
        System.out.println("CDPlay有参构造器调用实例");
    }

    //暴露一个公共的方法 给外部调用进行播放
    public void play() {
        if (compactDisc == null) {
            System.out.println("内部成员变量compactDisc为空");
            return;
        }
        compactDisc.play();
    }

}
