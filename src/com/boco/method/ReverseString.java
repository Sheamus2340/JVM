package com.boco.method;

/**
 * Created by Sheamus on 2018/5/28.
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String str = "abcdef";
        System.out.println(reverseString.reverseString(str));
        System.out.println(reverseString.reverseNumber(5));
        System.out.println(reverseString.function(5));
    }

    public String reverseString(String str) {
        if(str.length() == 0) {
            return str;
        } else {
            return reverseString(str.substring(1, str.length())) + str.substring(0, 1);
        }
    }

    public int reverseNumber(int n) {
        if(n == 0) {
           return 1;
        } else {
            return reverseNumber(n - 1) * n;
        }
    }

    public int function(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
           return function(n - 1) + function(n - 2);
        }
    }
}
