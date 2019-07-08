package com.ht.test.thread_test;

public class test01 {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        my.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<10;i++){
            System.out.println("main线程"+i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(MyThread.currentThread().getName()+" "+i);
        }
    }
}
