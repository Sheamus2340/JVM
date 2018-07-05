package com.boco.jvm.loader;

/**
 * Application ClassLoader的信息：
 a. 缓存机制：同批次虚拟机中，被相同类加载器加载过的类将不会再次被加载进内存。
 b. 全盘负责：类加载器加载某一个类时，该类中所依赖和引用的其他类，也将由此类加载器加载。
 * Created by Sheamus on 2018/7/5.
 */
public class ApplicationClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
    }
}
