##### 框架
1.Spring框架 4天
2.SpringMVC框架 3天
3.Redis-NoSql数据库 2天

框架怎么学习？
1.框架做什么的
2.框架的使用方式,语法

Spring的核心IOC
依赖：UserService--UserDao完成一个操作
classA使用了classB的属性或者方法,叫做classA依赖classB
IOC:控制反转,是一个概念,一个思想。用来指导我们如何创建,管理,使用对象的。  
AOP：面向切面编程

spring是一个企业级开发框架，是软件设计层面的框架

### 如何使用IOC 
创建maven工程,通过pom.xml添加spring

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>SpringTest</groupId>
    <artifactId>SpringTest</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
         <!--单元测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.0.11.RELEASE</version>
        </dependency>
        <!--简化bean的，不用写get跟set方法 它自动帮你生成-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.6</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

</project>
```

##### 创建实体类 Student

```java
package com.gdchent.cn;
import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private int age;
}

```

##### 传统方式要手动创建bean对象

```java
package com.gdchent.cn;

public class Application {

    public static void main(String[] args) {
      

        Student student=new Student();
        //student.set
    }
}

```

##### 通过IOC创建对象，在配置文件中添加管理的对象，xml格式的配置文件，文件名可以自定义

spring.xml示例代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--bean元素：表示当前的对象需要有spring容器管理
     class:被管理对象的类全名
     -->
    <bean id="service" class="com.gdchent.cn.service.MessageService"></bean>
    <bean id="printer" class="com.gdchent.cn.service.MessagePrinter">
        <property name="messageService" ref="service" ></property>

    </bean>

    <!--对象是放入到Spring的容器（Map<id,对象>）-->
    <bean id="someServiceBean" class="com.gdchent.cn.service.SomeServiceImpl">

    </bean>
    <bean id="student" class="com.gdchent.cn.service.Student">
        <property name="age" value="22" />
        <property name="id"  value="1" />
        <property name="name" value="lisi" />
    </bean>
</beans>
<!--xsd:是约束文件的拓展名,xsd的约束文件功能强,验证比较全面
 文件的url地址，是唯一的
 -->

```

##### 复习Spring ioc容器

##### 1.使用BeanFactory 这个容器来创建实例对象

示例代码如下：

```java
  /**
 * 需求：测试 从xml配置文件 读取Java的bean实例
 */
public class HelloWorldApplication {

    public static void main(String ...args){
        // 第一步从配置文件 读取xml文件信息
        ClassPathResource classPathResource=new ClassPathResource("HelloWorldBeans.xml");
        //第一步  读取xml文件信息
        XmlBeanFactory factory=new XmlBeanFactory(classPathResource);
        //获取bean实例之后
        HelloWorld helloWorld=factory.getBean(HelloWorld.class);
        System.out.println("get:"+helloWorld.getMessage());
    }
}
```

##### 2 使用ApplicationContext容器 

首先 通过点进去看源码我们可以发现，ApplicationContext它是一个接口，它有3个具体实现类。

1.**FileSystemXmlApplicationContext** ：该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径。就是你xml配置文件路径必须是绝对路径 否早找不到资源 工厂无法生产具体的实例。

使用示例代码如下：

```java
 /**
 * 使用FileSystemXmlApplicationContext这个类来读取xml文件配置  必须使用绝对路径
 */
public class HelloWorldFileSystemXmlApplicationContextTest {

    public static void main(String ...args){

        // 第一步还是需要获取 上下问对象实例
        String config="D:/software/SpringTest/src/main/resources/HelloWorldBeans.xml";
        ApplicationContext context= new FileSystemXmlApplicationContext(config);//使用绝对路径
        //HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld"); //可以通过xml的id来获取bean对象实例
        HelloWorld helloWorld=context.getBean(HelloWorld.class);
        System.out.println("输出message字段:"+helloWorld.getMessage());  //输出message字段:Hello World!
    }
}

```

2.**ClassPathXmlApplicationContext**：就是你的xml的文件路径可以是相对路径 你只需要配置环境变量CLASSPATH中配置即可,因为，容器会从 CLASSPATH 中搜索 bean 配置文件。

示例测试代码如下：

```java
public class HelloWorldClassPathXmlApplicationContextTest {

    public static void main(String ...args){

        // 第一步还是需要获取 上下问对象实例
        String config="HelloWorldBeans.xml"; //如果使用这种方式这里用的就是相对路径
        ApplicationContext context= new ClassPathXmlApplicationContext(config);//使用绝对路径
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld"); //可以通过xml的id来获取bean对象实例
        HelloWorld helloWorld2= (HelloWorld) context.getBean("helloWorld"); //这个是实例2

        //如果这2个是使用单例模式创建出来的  那么他们的内存地址 肯定是一样的
        System.out.println("h1:"+helloWorld);
        System.out.println(helloWorld2==helloWorld); //通过输出结果可以确定 默认是使用单例模式创建bean实例的
        //HelloWorld helloWorld=context.getBean(HelloWorld.class);
        System.out.println("输出message字段:"+helloWorld.getMessage());

    }
}

```

给出Spring容器的HelloWorldBeans.xml的配置文件

示例代码如下：

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- class就是这个xml的bean要映射到哪个bean的class
      scope确定作用域 只有2个属性
      默认使用单例方式创建实例对象
      可以通过在Java程序中创建2个bean的实例的内存地址是否一样来确定
    -->
    <bean id="helloWorld" name="helloWorld" class="com.gdchent.cn.service.HelloWorld" lazy-init="true"
        scope="singleton"
    >
        <property name="message" value="Hello World!"/>
    </bean>

</beans>
```

##### Spring Bean的后置处理器



先看examBean.xml配置文件示例代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="exampleBean" class="com.gdchent.cn.scope.ExampleBean"
     init-method="init" destroy-method="destroy"
    >

    </bean>
    <bean class="com.gdchent.cn.scope.InitExampleBean"/>
</beans>
```



示例代码如下：

```java
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
    //对应xml指定的初始化方法
    public void init() {
        System.out.println("实例初始化回调方法 触发");
    }

    public void destroy(){
        System.out.println("销毁实例bean");
    }
}
```

这是实现 BeanPostProcessor 的非常简单的例子，它在任何 bean 的初始化的之前和之后输入该 bean 的名称。你可以在初始化 bean 的之前和之后实现更复杂的逻辑，因为你有两个访问内置 bean 对象的后置处理程序的方法。这里是 **InitExampleBean.java** 文件的内容：

```java
package com.gdchent.cn.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitExampleBean implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beforeInitialization:"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("afterInitialization:"+beanName);
        return bean;
    }

}
```

##### Spring 依赖注入

TextEditor.java文件

```java
package com.gdchent.cn.di;

public class TextEditor {

    private SpellChecker spellChecker; 
    public TextEditor(){
        System.out.println("TextEditor无参数构造器");
    }
    public TextEditor(SpellChecker spellChecker){ //这个类依赖于SpellChecker这个类
        System.out.println("TextEditor有参数构造器");
        this.spellChecker=spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}

```

上面这个类依赖于SpellChecker这个类，来做自己的事，这在Java开发中经常会写这样的代码。

下面给出SpellChecker.java文件代码：

```java
package com.gdchent.cn.di;

/**
 * 这个类 被其它的类依赖着
 */
public class SpellChecker {

    public SpellChecker(){
        System.out.println("Inside SpellChecker constructor");
    }
    public void checkSpelling(){
        System.out.println("Inside checkSpelling");
    }
}

```

然后我们看下textEditorBeans.xml的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="textEditor" class="com.gdchent.cn.di.TextEditor">
         <!--构造函数-->
        <constructor-arg ref="spellChcker"/>
    </bean>
    <bean id="spellChcker" class="com.gdchent.cn.di.SpellChecker"/>
</beans>
```

最后我们通过main函数进行测试，示例代码如下：

```java
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

```

输出结果：

```txt
Inside SpellChecker constructor
TextEditor有参数构造器
Inside checkSpelling
```

##### 构造函数带参数依赖注入方式

###### 方式1： type 属性显式的指定了构造函数参数的类型

首先进入配置文件，示例代码如下：

```xml
 <bean id="foo" class="com.gdchent.cn.constructor.Foo">
        <!--<constructor-arg ref="bar"/>-->
        <!--<constructor-arg ref="baz"/>-->
        <!--基于type方式指定实体bean 这种叫做显性指定构造器参数类型-->
        <constructor-arg type="int" value="2001"/>
        <constructor-arg type="java.lang.String" value="gdchent"/>
    </bean>
```

Java实体**Foo.java**文件：

```java
package com.gdchent.cn.constructor;


/**
 * @author: gdchent
 * @date: 2019/10/8
 * @description:测试Spring的依赖注入
 */
public class Foo {
    private Bar bar;
    private Baz baz ;
    private int year;
    private String name;
    public Foo() {
        System.out.println("无参构造大佬调用了");
    }

    public Foo(Bar bar, Baz baz){
        System.out.println("有参构造大佬调用了");
        this.bar=bar;
        this.baz=baz;
    }
    public Foo(int year,String name){
        System.out.println("基本数据类型构造函数被调用了");
        this.year=year;
        this.name=name;
    }

    public Foo(Bar bar, Baz baz, int year, String name) {
        this.bar = bar;
        this.baz = baz;
        this.year = year;
        this.name = name;
    }

    //调用装b方法
    public void startInstallB(){
        System.out.println("Kaishi 装B");
    }
}
```

以上这种方式，是显示在xml的bean标签里面 通过type属性来显示指定 context容器显示创建bean到底调用哪个构造函数.

###### 方式1： index 属性隐式的指定了构造函数参数的类型

**setMethodTextEditorBeans.xml**示例代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="textEditor" class="com.gdchent.cn.setmethod.TextEditor">
        <!--会调用设置函数-->
        <property name="spellChecker" ref="spellChecker"/>
    </bean>
    <bean id="spellChecker" class="com.gdchent.cn.setmethod.SpellChecker"/>
</beans>
```

你应该注意定义在基于构造函数注入和基于设值函数注入中的 Beans.xml 文件的区别。唯一的区别就是在基于构造函数注入中，我们使用的是〈bean〉标签中的〈constructor-arg〉元素，而在基于设值函数的注入中，我们使用的是〈bean〉标签中的〈property〉元素。

###### spring注入集合

首先看Java的bean实例，**JavaCollection.java**实例代码:

```java
package com.gdchent.cn.list;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
public class JavaCollection {

    //列表集合
    List addressList;
    Set addressSet;
    Map addressMap ;

    Properties addressProp ;

    public List getAddressList() {
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Set getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Map getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }
}

```

然后看下spring注入文件,**collectBeans.xml**文件代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="javaCollection" class="com.gdchent.cn.list.JavaCollection">
        <property name="addressList">
            <list>
                <value>印第安纳</value>
                <value>迈阿密</value>
                <value>克利夫兰</value>
                <value>洛杉矶</value>
            </list>
        </property>
        <property name="addressSet">
            <set>
                <value>印第安纳</value>
                <value>迈阿密</value>
                <value>克利夫兰</value>
                <value>洛杉矶</value>
            </set>

        </property>
        <property name="addressMap">
            <map>
                <entry key="1" value="印第安纳"/>
                <entry key="2" value="迈阿密"/>
                <entry key="3" value="克利夫兰"/>
                <entry key="4" value="洛杉矶"/>
            </map>
        </property>

        <property name="addressProp">
            <props>
                <prop key="one">印第安纳</prop>
                <prop key="two">迈阿密</prop>
                <prop key="three">克利夫兰</prop>
                <prop key="four">洛杉矶</prop>
            </props>
        </property>
    </bean>
</beans>
```

##### 手写模拟实现IOC框架:

首先我们看下iocTestBeans.xml文件：

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--property的value属性只能针对于基本数据类型，而如果要使用引用数据类型使用ref属性即可-->
    <bean id="student" class="com.gdchent.cn.service.Student">
        <property name="age" value="22" />
        <property name="id"  value="1" />
        <property name="name" value="lisi" />
        <property name="address" ref="address" />
    </bean>

    <bean id="address" class="com.gdchent.cn.service.Address">
        <property name="id" value="1" />
        <property name="name" value="address的实体类地址-广东深圳" />
    </bean>
</beans>
```

接下来我们看下ioc代码，首先看**ApplicationConext.java**代码：

```java
package com.gdchent.cn.ioc;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
public interface ApplicationConext {
     public Object getBean(String path);
}

```

然后我们看下**ClassPathXmlApplicationContext.java**代码：

```java
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
	 //这个暴露给外部调用获取对象的方法 参数是bean标签的id
    public Object getBean(String id) {
        System.out.println("实现类的getBean:"+id);
        return ioc.get(id);
    }

    //通过Class来获取对象
    public Object getBean(Class requiredType){
        return iocMap.get(requiredType);
    }
}
```

总结ClassPathXmlApplicationContext构造函数里面的实现思路：

第一步 通过SAXReader 来解析xml文件

第二步 通过拿到document对象  来获取最外面的根节点，也就是xml里面的beans标签

第三步 因为Element这个节点类，它里面是基于List集合，所以它这里是通过迭代器来进行遍历

第四步 在while循环遍历中获取 bean标签对象元素

第五步 就是在while循环里面继续获取bean标签的property属性

第六步 将遍历设置好值的对象 添加到map对象中

以上就是解析xml 文件读取标签的整个逻辑

下面是**MainApplication.java**文件：

```java
package com.gdchent.cn.ioc;

import com.gdchent.cn.service.Student;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:简单实现ioc 底层原理
 */
public class MainApplication {

    public static void main(String[] args) {
        String config="D:/software/SpringTest/src/main/resources/iocTestBeans.xml";
        ApplicationConext conext=new ClassPathXmlApplicationContext(config);
        Student student = (Student) conext.getBean("student");
        System.out.println("获取实例对象"+student);
        Student student2 = (Student) conext.getBean(Student.class);
        System.out.println("获取实例对象2:"+student2);
    }
}
```

运行效果图如下：

![image](https://github.com/gdchent/SpringTest/blob/master/effectImg/手写模拟实现ioc原理.png)

