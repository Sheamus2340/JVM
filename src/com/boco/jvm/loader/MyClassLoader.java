package com.boco.jvm.loader;

import java.io.*;

/**
 * 自定义类加载器，重写findClass的方式
 * 根据全限定类名来加载Demo类的字节码文件，如果该类还未被编译，则先编译后加载字节码
 * Created by Sheamus on 2018/7/5.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = null;
        try {
            classData = getClassData(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(classData == null){
            throw new RuntimeException("类加载失败！");
        }

        return defineClass(name.substring(name.indexOf(".")+1), classData, 0, classData.length);

    }

    /**
     * 加载字节码
     * @param name
     * @return
     */
    private byte[] getClassData(String name) throws FileNotFoundException {
        String fileName = name.replaceAll("\\.", File.separator+File.separator)+".class";
        File classFile = new File(fileName);
        if(!classFile.exists()){
            if(!compileFile(name))
                throw new FileNotFoundException("没有发现文件！");
        }

        FileInputStream fis = new FileInputStream(classFile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bArray = null;
        try {
            bArray = new byte[fis.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        int hasRead = -1;
        try {
            while((hasRead = fis.read(bArray)) != -1){
                baos.write(bArray, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("已经将字节码转换成二进制数据流写入内存！");
        return baos.toByteArray();
    }

    /**
     * 编译文件
     * @param name
     * @return
     */
    private boolean compileFile(String name) {
        Process p = null;
        name = name.replaceAll("\\.", File.separator+File.separator)+".java";
        try {
            p = Runtime.getRuntime().exec("javac " + name);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("编译完成！");
        return p.exitValue() == 0;
    }
}
