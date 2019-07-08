package com.ht.test;


class A{}
public class Test extends A{
    public  void test(){
        String s = getClass().getSuperclass().getName();
        System.out.println(s);
    }

    public static void hello(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ((Test)null).hello();
    }
}
