package com.ht.test.stack;

class Node<E>{
    Node<E> next = null;
    E data;
    public Node(E data){
        this.data = data;
    }

}

public class MyStack_ByLink<E> {

    private Node<E> top = null;

    public boolean isEmpty(){
        return top == null;
    }

    public void push(E data){
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public E peek(){
        if(isEmpty())return null;
        return top.data;
    }

    public E pop(){
        E e = peek();
        top = top.next;
        return e;
    }


    public static void main(String[] args) {
        MyStack_ByLink stack = new MyStack_ByLink();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
