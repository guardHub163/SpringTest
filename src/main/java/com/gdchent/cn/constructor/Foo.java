package com.gdchent.cn.constructor;


/**
 * @author: gdchent
 * @date: 2019/10/8
 * @description:
 */
public class Foo {
    private Bar bar;
    private Baz baz ;
    private int year;
    private String name;
    public Foo() {
        System.out.println("无参构造大佬调用了");
    }

    public Foo(Bar bar, Baz baz){
        System.out.println("有参构造大佬调用了");
        this.bar=bar;
        this.baz=baz;
    }
    public Foo(int year,String name){
        System.out.println("基本数据类型构造函数被调用了");
        this.year=year;
        this.name=name;
    }

    public Foo(Bar bar, Baz baz, int year, String name) {
        this.bar = bar;
        this.baz = baz;
        this.year = year;
        this.name = name;
    }

    //调用装b方法
    public void startInstallB(){
        System.out.println("Kaishi 装B");
    }
}
