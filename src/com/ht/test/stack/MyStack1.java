package com.ht.test.stack;

import java.util.Stack;

public class MyStack1 {

    private MyStack_ByArray<Integer> stack = null;
    private MyStack_ByArray<Integer> min = null;

    public MyStack1(){
        stack = new MyStack_ByArray<>();
        min = new MyStack_ByArray<>();
    }

    public void push(int data){
        stack.push(data);
        if(min.isEmpty()||min.peek()>data){
            min.push(data);
        }
    }

    public int pop(){
        Integer e = stack.pop();
        if(e==min.peek()){
            min.pop();
        }
        return e;
    }

    public int min(){
        return min.peek();
    }




    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(2);
        stack1.push(3);
        stack1.push(1);
        stack1.push(6);
        stack1.push(-6);
        stack1.push(2);
        stack1.push(10);
        System.out.println(stack1.min());
    }

}
