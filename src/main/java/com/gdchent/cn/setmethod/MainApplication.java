package com.gdchent.cn.setmethod;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        String config="setMethodTextEditorBeans.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(config);
        TextEditor textEditor=context.getBean(TextEditor.class);
        textEditor.spellCheck();
        OuterBean outerBean= (OuterBean) context.getBean("outerBean");
        System.out.println(outerBean);

    }
}
