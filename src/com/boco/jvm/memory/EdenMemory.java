package com.boco.jvm.memory;

/**
 * Eden区的内存分配
 * Created by Sheamus on 2018/4/24.
 * 场景：
 *  1. 指定堆内存大小为20M； -Xms20M -Xmx20M
 *  2. 指定新生代为10M；     -Xmn10M
 *  3. 指定Eden的比例为8；-XX:SurvivorRatio=8 --> Eden区与Survivor区的大小比值
 */
public class EdenMemory {
    public static void main(String[] args) {
        byte[] bt1 = new byte[2 * 1024 * 1024];
        byte[] bt2 = new byte[2 * 1024 * 1024];
        byte[] bt3 = new byte[2 * 1024 * 1024];
        byte[] bt4 = new byte[4 * 1024 * 1024];

        System.gc();
    }
}
