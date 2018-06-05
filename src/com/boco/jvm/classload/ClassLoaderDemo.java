package com.boco.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义加载器
 * Created by Sheamus on 2018/6/4.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                //获取class的类名 com.boco.jvm.classload.ClassLoaderDemo
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                //当没有加载到ClassLoaderDemo.class文件的时候，让父加载器去加载
                if(resourceAsStream == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] buff = new byte[resourceAsStream.available()];
                    resourceAsStream.read(buff);
                    return defineClass(name,buff,0,buff.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }

            }
        };

        Object o = classLoader.loadClass("com.boco.jvm.classload.ClassLoaderDemo").newInstance();
        System.out.println(o.getClass());//o对象所对应的类加载器是自定义的
        System.out.println(o instanceof ClassLoaderDemo);//false 不同类加载器加载的类不同，所以不是实例

    }
}
