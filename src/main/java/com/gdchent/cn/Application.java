package com.gdchent.cn;

public class Application {

    public static void main(String[] args) {
        System.out.println("应用程序application_start");

        //创建打印机对象
        MessagePrinter messagePrinter=new MessagePrinter();

        //创建消息服务对象
        MessageService messageService=new MessageService();

        //设置service
        messagePrinter.setMessageService(messageService);

        //打印消息
        messagePrinter.printMessage();


    }
}
