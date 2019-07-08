package com.ht.test.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinAndMax {

    //获取数组中的最大值与最小值
    private static void getMaxAndMin(int array[]){
        if(array.length<1)return;
        int max = array[0];
        int min = array[0];
        for(int i = 0;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println("max is "+max);
        System.out.println("min is "+min);

    }

    //找出数组中第二大数   --方法一  先排序
    private static int findSecMax1(int array[]){
        Arrays.sort(array);
        int i = array.length-1-1;
        while(i>=0){
            if(array[i] == array[array.length-1])i--;
            else return array[i];
        }
        return array[array.length-1];
    }

    private static int findSecMax2(int array[]){

        int max = array[0];
        int secMax = Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                secMax = max;
                max = array[i];
            }else if(array[i]<max){
                if(array[i]>secMax){
                    secMax = array[i];
                }
            }
        }
        return secMax;
    }


    //求最大子数组之和 -- 方法一暴力破解
    private static int maxSubArray1(int array[]){
        int max = array[0];
        int thisSum = 0;
        for(int i=0;i<array.length;i++){
            thisSum = 0;
            for(int j=i;j<array.length;j++){
                thisSum+=array[j];
                if(thisSum>max)max = thisSum;
            }
        }

        return max;
    }

    //求最大子数组之和 -- 方法二 动态规划
    private static int maxSubArray2(int array[]){

        return 0;
    }

    //找出数组中重复最多的数字 --，使用map映射表
    private static int findMostNumInArray(int array[]){

        int max = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
        }

        //遍历map，找出value最大的key
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
           if(e.getKey()>max){
               max = e.getKey();
           }
            System.out.println(e.getKey()+":"+e.getValue());
        }
        return max;
    }


    //求数组中两两相加等于sum的组合种数 --方法一 蛮力法暴力破解
    private static void findSum1(int array[],int sum){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    System.out.println(array[i]+","+array[j]);
                }
            }
        }
    }

    //求数组中两两相加等于sum的组合种数 --方法二，先排序，双指针，首尾相加比较
    private static void findSum2(int array[],int sum){
       Arrays.sort(array);
       int i = 0;
       int j = array.length-1;
       while(i<j){
           if(array[i]+array[j]==sum){
               System.out.println(array[i]+","+array[j]);
               i++;
               j--;
           }
           if(array[i]+array[j]<sum)i++;
           if(array[i]+array[j]>sum)j--;
       }
    }

    //找出数组中第k个最小的数--  剪枝法
    private static int getKMin(){

    }


    public static void main(String[] args) {
        int array [] = new int[]{1,7,17,2,6,3,14,10};
        //getMaxAndMin(array);
//        int secMax1 = findSecMax1(array);
//        int secMax2 = findSecMax2(array);
//        System.out.println(secMax1);
//        System.out.println(secMax2);
//        int maxSubArray1 = maxSubArray1(array);
//        System.out.println(maxSubArray1);
//        int mostNum= findMostNumInArray(array);
//        System.out.println(mostNum);
        findSum2(array,20);
    }
}
