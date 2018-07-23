package com.boco.jvm.loader;

/**
 * https://blog.csdn.net/reliveit/article/details/39694349
 * 得到Class对象的方式
 * 1. Class.forName()
 * 2. 对象.getClass()
 * 3. 类.class
 * Created by Sheamus on 2018/7/5.
 */
public class ClassForNameTest {

    static {
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.boco.jvm.loader.ClassForNameTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<ClassForNameTest> classForNameTestClass = ClassForNameTest.class;

        Class<? extends ClassForNameTest> aClass = new ClassForNameTest().getClass();


    }
}
