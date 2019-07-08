package com.ht.test.thread_test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test03 {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        //创建三个窗口
        Thread t1 = new Thread(t,"窗口1");
        Thread t2 = new Thread(t,"窗口2");
        Thread t3 = new Thread(t,"窗口3");
        Thread t4 = new Thread(t,"窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Ticket implements Runnable{
    private int ticket = 100;//一百张票

    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        //窗口一直开启
        while (true) {
            lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖：" + ticket--);
            }
                lock.unlock();
        }
    }
}
