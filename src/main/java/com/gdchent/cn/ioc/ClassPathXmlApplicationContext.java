package com.gdchent.cn.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

import javax.xml.ws.soap.MTOM;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private Map<Class,Object> iocMap=new HashMap<Class, Object>();
    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String path) {

        try {
            this.path = path;
            //第一步 进行xml 解析
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            System.out.println("document" + document);
            //第二步 获取最外面的beans根节点
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            System.out.println("root:" + rootElement);
            //遍历节点
            while (iterator.hasNext()) {
                //循环获取每一个子节点
                Element element = iterator.next();
                System.out.println(element);
                String id = element.attributeValue("id"); //student address
                String className = element.attributeValue("class");
                //通过反射机制来创建对象
                Class clazz = Class.forName(className);
                Constructor constructor = clazz.getConstructor(); //获取无参数构造器
                System.out.println("constructor:"+constructor);
                Object object = constructor.newInstance(); //通过无参构造器函数对象来获取对象
                System.out.println("bean对象："+object);
                Iterator<Element> beanIter = element.elementIterator(); //节点属性
                while (beanIter.hasNext()) {
                    Element property = beanIter.next();
                    String name= property.attributeValue("name");
                    String valueStr = property.attributeValue("value");
                    String ref = property.attributeValue("ref");
                    if(ref==null){

                        String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                        Field field=clazz.getDeclaredField(name);
                        //给对象的属性设置值
                        Method method=clazz.getDeclaredMethod(methodName,field.getType()); //这个方法是有参数的
                        //根据成员变量的数据类型将 value进行转换
                        //System.out.println("field:"+field.getType().getName());
                        Object value=null;
                        if(field.getType().getName()=="long"){
                            value=Long.parseLong(valueStr);
                        }
                        if(field.getType().getName()=="java.lang.String"){
                            value=valueStr;
                        }
                        if(field.getType().getName()=="int"){
                            value=Integer.parseInt(valueStr);
                        }
                        if(value!=null){
                            method.invoke(object,value);
                        }
                        //将目标对象放入ioc的map容器
                        ioc.put(id, object);
                        iocMap.put(clazz,object);
                    }else{
                         //如果有ref属性  赋值ref属性指向的对象
                        System.out.println("ioc"+ref);
                    }

                }

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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {

        }

    }

    //这个暴露给外部调用获取对象的方法 参数是bean标签的id

    public Object getBean(String id) {
        return ioc.get(id);
    }

    //通过Class来获取对象
    public Object getBean(Class requiredType){
        return iocMap.get(requiredType);
    }
}
