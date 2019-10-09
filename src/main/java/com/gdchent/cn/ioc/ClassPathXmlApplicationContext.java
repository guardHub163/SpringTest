package com.gdchent.cn.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

import javax.xml.ws.soap.MTOM;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
public class ClassPathXmlApplicationContext implements ApplicationConext {

    private String path;
    private Map<String, Object> ioc = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String path) {

        try {
            this.path = path;
            //第一步 进行xml 解析
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            System.out.println("document" + document);
            //获取最外面的beans根节点
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            System.out.println("root" + rootElement);
            //遍历节点
            while (iterator.hasNext()) {
                Element element = iterator.next();
                System.out.println(element);
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                System.out.println("id:" + id);
                System.out.println("class:" + className);
                //通过反射机制来创建对象
                Class clazz = Class.forName(className);
                Constructor constructor = clazz.getConstructor(); //获取无参数构造器
                System.out.println(constructor);
                Object object = constructor.newInstance();
                System.out.println(object);
                Iterator<Element> beanIter = element.elementIterator();
                while (beanIter.hasNext()) {
                    Element property = beanIter.next();
                    String name= property.attributeValue("name");
                    String value = property.attributeValue("value");
                    System.out.println("bean_name:"+name);
                    System.out.println("bean_value:"+value);
                    String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    System.out.println(methodName);
                }
                //将目标对象放入ioc的map容器
                ioc.put(id, object);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public Object getBean(String id) {
        return ioc.get(id);
    }
}
