package com.ht.test.thread_test;

public class test02 implements Runnable {
    public static void main(String[] args) {

        test02 t = new test02();
        Thread thread = new Thread(t);
        thread.start();

        for(int i=0;i<10;i++){
            System.out.println("main线程"+i);
        }
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("runnable"+i);
        }
    }
}
