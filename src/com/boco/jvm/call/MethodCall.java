package com.boco.jvm.call;

/**
 * 方法调用 -- 静态分派调用（方法重载）
 * 方法的标签只有：方法名，参数类型和顺序
 * Created by Sheamus on 2018/6/5.
 */
public class MethodCall {
    static class Parent{}

    static class Child1 extends Parent{}

    static class Child2 extends Parent{}

    public void sayhello(Child1 c) {
        System.out.println("c1 is call");
    }

    public void sayhello(Child2 c) {
        System.out.println("c2 is call");
    }

    public void sayhello(Parent c) {
        System.out.println("p is call");
    }

    public static void main(String[] args) {
        Parent p1 = new Child1();
        Parent p2 = new Child2();

        MethodCall call = new MethodCall();
        call.sayhello(p1);
        call.sayhello(p2);
    }


}
