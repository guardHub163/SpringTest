package com.gdchent.cn.setmethod;

/**
 * 这个类 被其它的类依赖着
 */
public class SpellChecker {

    public SpellChecker(){
        System.out.println("Inside SpellChecker constructor");
    }

    public void checkSpelling(){
        System.out.println("Inside checkSpelling");
    }


}
