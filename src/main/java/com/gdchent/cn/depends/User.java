package com.gdchent.cn.depends;


import java.util.ArrayList;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */

public class User {

    private long id=0 ;
    private String name=null;
    private int age ;
    private ArrayList<Address> addrssList=null;
    public User(){
        System.out.println("User输出");
    }
    public User(long id, String name, int age, ArrayList<Address> addrssList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addrssList = addrssList;
    }
}