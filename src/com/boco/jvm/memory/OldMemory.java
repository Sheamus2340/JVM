package com.boco.jvm.memory;

/**
 * 老年代
 * Created by Sheamus on 2018/4/24.
 */
public class OldMemory {
    private static int M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] b = new byte[10 * M];

    }
}
