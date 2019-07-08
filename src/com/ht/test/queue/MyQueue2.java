package com.ht.test.queue;

import java.util.Stack;

/**
 * 使用两个栈模拟队列操作
 */
public class MyQueue2<E> {
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public void put(E data){
        s1.push(data);
    }
    public E pop(){
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public boolean isEmpty(){
        return s1.isEmpty()&&s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2<Integer> queue2 = new MyQueue2<>();
        queue2.put(1);
        queue2.put(3);
        queue2.put(4);
        queue2.put(6);
        queue2.put(9);
        while (!queue2.isEmpty()){
            System.out.println(queue2.pop());
        }

    }
}
