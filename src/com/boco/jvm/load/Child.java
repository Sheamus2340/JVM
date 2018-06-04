package com.boco.jvm.load;

/**
 * Created by Sheamus on 2018/6/1.
 */
public class Child extends Parent {
    static {
        System.out.println("Child 初始化");
    }

    {
        System.out.println("Child 对象");
    }

    public Child() {
        System.out.println("Child 对象 构造");
    }

    public static final int sam = 20;

  /*  public static void main(String[] args) {
        Child child = new Child();
    }*/
}
