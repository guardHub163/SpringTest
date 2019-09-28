package com.gdchent.cn.service;


import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageService messageService;

    public MessagePrinter() {
        super();
        System.out.println("messagePrint开始");
    }

    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService){
        this.messageService=messageService;
    }

    public void printMessage(){
        System.out.println(messageService.getMessage());
    }


}
