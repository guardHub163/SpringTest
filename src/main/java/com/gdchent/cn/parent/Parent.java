package com.gdchent.cn.parent;

import lombok.Data;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:Parent实体类
 */
@Data
public class Parent {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
