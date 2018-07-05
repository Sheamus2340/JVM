package com.boco.jvm.loader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * BootStrapClassLoader的加载路径
 * Created by Sheamus on 2018/7/5.
 */
public class BootStrapClassLoaderTest {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urLs) {
            System.out.println(url.getPath());
        }
    }
}
