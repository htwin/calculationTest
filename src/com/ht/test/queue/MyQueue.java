package com.ht.test.queue;

class Node<E>{
    Node<E> next = null;
    E data;
    public Node(E data){
        this.data = data;
    }
}

/**
 * 使用链表实现队列
 * @param <E>
 */
public class MyQueue<E> {
    private Node<E> head = null;

    private Node<E> tail = null;

    public boolean isEmpty(){
        return head == null;
    }

    public void put(E data){
        Node<E> node = new Node<>(data);
        if(isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public E pop(){
        if(isEmpty())return null;
        E e = head.data;
        head = head.next;
        return e;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }



}
