package com.boco.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Sheamus on 2018/6/4.
 */
public class DefineClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);

                if(resourceAsStream == null) {
                    return super.findClass(name);
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

        Object o = classLoader.loadClass("com.boco.jvm.classload.DefineClassLoader").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof DefineClassLoader);//true 这个是使用了双亲委派机制

    }
}
