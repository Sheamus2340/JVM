package com.boco.jvm.option;

/**
 * Created by Sheamus on 2018/6/1.
 */
public class TestStackDeep {
    private static int count = 0;
    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try{
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }

    }
}
