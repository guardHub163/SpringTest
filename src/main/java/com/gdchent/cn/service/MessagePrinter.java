package com.gdchent.cn.service;


import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageService messageService;

    public MessagePrinter() {
        super();
        System.out.println("打印机调用无参数构造方法");
    }

    public MessagePrinter(MessageService messageService) {
        System.out.println("打印机调用有参数构造方法");
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService){
        this.messageService=messageService;
    }

    public void printMessage(){
        System.out.println("输出messagePrinter:"+messageService.getMessage());
    }


}
