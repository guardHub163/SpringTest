package com.gdchent.cn.service;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private int age;
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }
}
