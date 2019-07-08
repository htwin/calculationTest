package com.ht.test.thread_test;

public class Produce {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();
        Baozipu pu = new Baozipu("包子铺",baozi);
        Chihuo chi = new Chihuo("吃货",baozi);
        pu.start();
        chi.start();
    }
}
class Baozi{
    String pier;
    String xianer;
    boolean flag = false;//包子资源，是否存在
}
class Baozipu extends Thread{

    private Baozi baozi;

    public Baozipu(String name,Baozi baozi){
        super(name);
        this.baozi = baozi;
    }

    public void run(){
        int count = 0;
        while (true){
            synchronized (baozi){
                if(baozi.flag==true){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺开始做包子");
                if(count%2==0){
                    baozi.pier = "冰皮";
                    baozi.xianer = "韭菜";
                }else{
                    baozi.pier = "面皮";
                    baozi.xianer = "大葱";
                }
                count ++;
                baozi.flag = true;
                System.out.println("包子做好了："+baozi.pier+baozi.xianer);
                System.out.println("吃货来吃吧");
                baozi.notify();
            }
        }
    }
}

class Chihuo extends Thread{
    private Baozi baozi;

    public Chihuo(String name,Baozi baozi){
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baozi) {
                if (baozi.flag == false) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃：" + baozi.pier + baozi.xianer + "包子");
                baozi.flag = false;
                baozi.notify();
            }
        }
    }
}

