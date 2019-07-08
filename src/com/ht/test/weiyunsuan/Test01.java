package com.ht.test.weiyunsuan;

/**
 * 如何用移位操作完成乘法运算
 */
public class Test01 {

    //m乘以2的n次方
    private static int powerN(int m,int n){
        for(int i=0;i<n;i++){
            m = m<<1;
        }
        return m;
    }

    //判断一个数是否为2的n次方 ---方法一
    private static boolean isPower1(int n){
        if(n<1)return false;
        int i=1;
        while (i<=n){
            if(i==n)return true;
            i<<=1;
        }
        return false;
    }
    //判断一个数是否为2的n次方 ---方法二
    private static boolean isPower2(int n){
       if(n<1)return false;
       int m = n&(n-1);
       return m==0;
    }


    //求二进制数中1的个数 -- 方法一
    private static int countOne1(int n){
        int count=0;
        while (n>0){
            if((n&1)==1)count++;
            n>>=1;
        }
        return count;
    }

    //求二进制数中1的个数 -- 方法二
    private static int countOne2(int n){
       int count = 0 ;
       while (n>0){
           if(n!=0)
               n = n&(n-1);
           count++;
       }
       return count;
    }
    public static void main(String[] args) {
        //System.out.println("3*8="+powerN(3,3));
        //System.out.println(isPower2(4));
        System.out.println(countOne2(7));
    }
}
