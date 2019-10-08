package com.gdchent.cn.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        String config="textEditorBeans.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        TextEditor textEditor=context.getBean(TextEditor.class);
        textEditor.spellCheck();
    }
}
