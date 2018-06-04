package com.boco.jvm.load;

/**
 * Created by Sheamus on 2018/6/1.
 */
public class Parent {
    static {
        System.out.println("Parent 初始化");
    }

    {
        System.out.println("Parent 对象");
    }

    public Parent() {
        System.out.println("Parent 对象 构造");
    }

    public static int num = 10;


}
