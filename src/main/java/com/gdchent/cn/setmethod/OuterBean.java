package com.gdchent.cn.setmethod;


/**
 * @author: gdchent
 * @date: 2019/10/9
 * @description:
 */
public class OuterBean {
    private InnerBean target;
    public OuterBean() {
        System.out.println("无参OuterBean调用");
    }


    public void setTarget(InnerBean innerBean){
        this.target=innerBean;
    }

    //内部类
    class InnerBean {
        public InnerBean() {
            System.out.println("无参InnerBean调用");
        }
    }


}
