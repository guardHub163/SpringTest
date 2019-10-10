package com.gdchent.cn.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */
public class InstanceFactory {
    private Map<Long,Car> carMap;

    //构造器
    public InstanceFactory(){
        carMap=new HashMap<Long, Car>();
        carMap.put(1L,new Car(1L,"宝马"));
        carMap.put(2L,new Car(2L,"奔驰"));
    }

    //提供工厂方法
    public Car getCar(long id){
        return carMap.get(id);
    }
}
