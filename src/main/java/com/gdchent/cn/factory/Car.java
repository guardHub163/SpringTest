package com.gdchent.cn.factory;

import lombok.Data;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */
@Data
public class Car {
    private long id;
    private String name;

    public Car() {
    }

    public Car(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
