package com.boco.jvm.gc;

/**
 * 引用计数法
 * 执行后，objA和objB会不会被GC呢？
 * Created by Sheamus on 2018/4/17.
 * 运行的时候要添加虚拟机参数才能看到垃圾回收日志：
 * -verbose:gc -XX:+PrintGCDetails
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        //假设在这行发生了GC，objA和objB是否被回收
        System.gc();
    }
}
