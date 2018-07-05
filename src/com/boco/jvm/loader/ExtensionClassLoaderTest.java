package com.boco.jvm.loader;

/**
 * Extension ClassLoader 的信息
 * Created by Sheamus on 2018/7/5.
 */
public class ExtensionClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader extensionClassLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extensionClassLoader);
        System.out.println("扩展类加载器路径： " + System.getProperty("java.ext.dirs"));
    }
}
