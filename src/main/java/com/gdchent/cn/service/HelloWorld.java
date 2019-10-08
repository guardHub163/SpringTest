package com.gdchent.cn.service;


import lombok.Data;

@Data
public class HelloWorld {
    private String message;

    public HelloWorld(){
        System.out.println("初始化第一次被调用的时候使用");
    }
    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

}
