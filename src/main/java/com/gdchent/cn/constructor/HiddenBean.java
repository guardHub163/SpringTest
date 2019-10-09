package com.gdchent.cn.constructor;

import lombok.Data;

/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
@Data
public class HiddenBean {

    private String name;
    private String address;
    public HiddenBean() {
    }

    public HiddenBean(String name, String address) {
        this.name = name;
        this.address = address;
    }

}



