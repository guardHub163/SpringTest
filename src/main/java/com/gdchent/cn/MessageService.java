package com.gdchent.cn;

import org.springframework.stereotype.Component;

/**
 * 打印服务
 */

@Component
public class MessageService {


    private String message;

    public MessageService(){
        super();
        System.out.println("MessageSevice开始");
    }


    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }

}
