package com.boco.jvm.loader;

/**
 * 测试自定义的classLoader
 * Created by Sheamus on 2018/7/5.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.boco.jvm.loader.Test");
        System.out.println(aClass.getName());
    }
}
