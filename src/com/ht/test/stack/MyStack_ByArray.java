package com.ht.test.stack;


import java.util.Arrays;

/**
 * 通过数组实现栈
 */
public class MyStack_ByArray<E> {
    Object stack[] ;
    int size = 0;//数组中元素的个数
    public MyStack_ByArray(){
        stack = new Object[10];//初始化长度为10
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return (E)stack[size-1];
    }

    public E pop(){
        E e = peek();
        stack[size-1] = null;
        size -- ;
        return e;

    }

    public void push(E data){
        ensureCapacity(size+1);
        stack[size++] = data;
    }

    /**
     * 检查容量
     * @param size
     */
    private void ensureCapacity(int size){
        if(size>stack.length){
            int newLen = 10;
            stack = Arrays.copyOf(stack,newLen);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        MyStack_ByArray<Integer> stack  = new MyStack_ByArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
       /*Node node = new Node(1);
       Node node2 = new Node(3);
       Node node3 = new Node(2);
       Node node4 = new Node(6);
       MyStack_ByArray<Node> stack  = new MyStack_ByArray<>();
        stack.push(node);
        stack.push(node2);
        stack.push(node3);
        stack.push(node4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }*/
    }

}
