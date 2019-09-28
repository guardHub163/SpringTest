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

