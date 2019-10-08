package com.gdchent.cn.scope;

public class ExampleBean  {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExampleBean(){
        System.out.println("构造器初始化");
    }
    ////对应xml指定的初始化方法
    public void init() {
        System.out.println("实例初始化回调方法 触发");
    }

    //对象xml指定的销毁方法
    public void destroy(){
        System.out.println("销毁实例bean");
    }

}
