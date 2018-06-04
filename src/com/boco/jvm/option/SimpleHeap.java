package com.boco.jvm.option;

/**
 * Created by Sheamus on 2018/6/1.
 */
public class SimpleHeap {

    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My Id is " + id);
    }

    public static void main(String[] args) {
        SimpleHeap simpleHeap1 = new SimpleHeap(1);
        SimpleHeap simpleHeap2 = new SimpleHeap(2);

        simpleHeap1.show();
        simpleHeap2.show();
    }
}
