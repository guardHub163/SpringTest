package com.gdchent.cn.factory;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: gdchent
 * @date: 2019/10/10
 * @description:
 */
@Data
public class StaticCarFactory {

    private static Map<Long,Car> carMap=new HashMap<Long, Car>();
    static {
        carMap.put(1L,new Car(1L,"宝马"));
        carMap.put(2L,new Car(2L,"奔驰"));
    }

    public static Car getCar(long id){
        return carMap.get(id);
    }
}
