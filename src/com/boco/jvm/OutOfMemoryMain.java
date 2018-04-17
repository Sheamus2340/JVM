package com.boco.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheamus on 2018/4/8.
 */
public class OutOfMemoryMain {
    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        while (true) {
            people.add(new OutOfMemoryMain.People());
            people.add(new OutOfMemoryMain.People("zhangsa",11));
        }
    }

    static class People {
        public String name;
        public int age;
        public People() {}
        public People(String name,int age) {
            this.name = name;
            this.age = age;
        }
    }
}
