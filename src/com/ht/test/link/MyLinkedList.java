package com.ht.test.link;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;
import java.util.Stack;

/**
 *关于链表的一系列操作
 * 增删改查
 * -从链表中删除重复元素
 * -找出链表中倒数第k个元素
 * -从尾到头输出链表
 * -寻找单链表的中间节点
 * -检测链表是否有环
 * -在不知道头指针的情况下删除指定节点
 */
public class MyLinkedList {

    Node head = null;//链表头的引用

    /**
     * 向链表中插入数据
     * @param data 插入数据的内容
     */
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 删除第index个节点
     * @param index 删除节点的索引
     * @return 删除成功返回true  失败返回false
     */
    public Boolean deleteNode(int index){
        if(index<0||index>length()){
            return false;
        }
        //删除第一个节点
        if(index == 1){
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while(curNode != null){
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 对链表进行排序
     */
    public void orderList(){
        Node curNode = head;
        Node nextNode = null;
        while (curNode.next!=null){
            nextNode = curNode.next;
            while (nextNode!=null){
                if(curNode.data>nextNode.data){
                    int temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
    }


    /**
     * 在指定位置添加元素
     * @param index 位置
     * @param data 数据
     */
    public void addInIndex(int index,int data){
        if(index<0||index>length()+1)return;
        Node node = new Node(data);

        if(index == 1){
            node.next = head;
            head = node;
        }
        int i = 2;
        Node temp = head;
        while (temp!=null){
               if(i==index){
                   node.next = temp.next;
                   temp.next = node;
               }
               temp = temp.next;
               i++;
        }
    }


    /**
     * 打印链表
     */
    public void printLinkList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null) System.out.print("->");
            temp = temp.next;
        }

    }

    /**
     * 返回链表的长度
     * @return
     */
    public int length() {
        Node temp = head;
        int i = 0;
        while(temp!=null){
            temp = temp.next;
            i++;
        }
        return i;
    }

    /**
     * 从链表中删除重复数据
     * @param head 传入的链表
     */
    public void deleteDuplicate(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node pre = null;
        Node curNode = head;
        while(curNode!=null){
            if(set.contains(curNode.data)){
                pre.next = curNode.next;
            }else{
                set.add(curNode.data);
                pre = curNode;
            }
            curNode = curNode.next;
        }


    }

    /**
     * 找出倒数第k个元素
     * @param k
     * @return
     */
    public Node findElem(int k){
        if(k<0||k>length())return null;
        Node p1 = head;
        Node p2 = head;
        int i =1;
        while (p1!=null&&i<k){
            p1 = p1.next;
            i++;
        }
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

    /**
     * 方法1 使用栈
     * 从尾到头输出单链表
     * @param head
     */
    public void printFromTail(Node head){
        System.out.println("使用栈");
        Stack<Integer> stack = new Stack<>();

        while (head!=null){
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"->");
        }
    }

    /**
     * 方法2 使用递归
     * 从尾到头输出链表
     * @param head
     */
    public void printFromTail2(Node head){
        if(head.next!=null){
            printFromTail2(head.next);
        }
        System.out.print(head.data+"->");
    }

    /**
     * 寻找链表的中间节点
     * @param head
     * @return
     */
    public Node findMidNode(Node head){
        //两个指针，一个一次走一步，一个一次走两步，快的走到最后节点，慢的刚好是中间节点
        Node p1 = head;
        Node p2 = head;
        while (p2!=null&&p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 检测链表是否有环
     * @param head
     * @return
     */
    public boolean isLoop(Node head){
        //快指针走两步，慢指针走一步，当两个指针相等的时候说明有环
        Node fast = head;
        Node slow = head;
        if(fast == null)return false;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)return true;
        }
        return false;


    }

    /**
     * 删除指定节点(不知道头指针)
     * @param node
     * @return
     */
    public void deleteNode(Node node){
        if(node ==null||node.next==null)return;
        //交换当前节点与下一节点的数据，然后当前节点跳过下一个节点
        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        node.next = node.next.next;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MyLinkedList link = new MyLinkedList();
        link.addNode(3);
        link.addNode(1);
        link.addNode(3);
        link.addNode(7);
        link.addNode(0);
        link.addNode(4);
        link.addNode(6);
        link.addNode(14);
        link.addNode(8);
        link.addNode(9);
        System.out.println("原始链表");
        link.printLinkList();//打印链表
       /* link.deleteNode(3);
        System.out.println("\n删除第3个元素");
        link.printLinkList();//打印链表*/
        System.out.println("\n排序后的链表");
        link.orderList();
        link.printLinkList();
        link.addInIndex(2,5);
        System.out.println("\n在2位置添加5");
        link.printLinkList();
        link.deleteDuplicate(link.head);
        System.out.println("\n删除重复数据之后");
        link.printLinkList();

        Node node = link.findElem(3);
        System.out.println("\n倒数第三个元素");
        System.out.println(node.data);
        System.out.println("从尾到头输出链表");
        link.printFromTail(link.head);//使用栈
        System.out.println("\n使用递归");
        link.printFromTail2(link.head);//使用递归

        System.out.println("\n中间节点");
        Node midNode = link.findMidNode(link.head);
        System.out.println(midNode.data);
        boolean isLoop = link.isLoop(link.head);
        if(isLoop) System.out.println("\n该链表有环");
        else System.out.println("\n该链表没有环");
        System.out.println("在不知道头指针的情况下删除倒数第二个节点");
        node =  link.findElem(2);
        link.deleteNode(node);//删除倒数第二个节点
        link.printLinkList();


    }


}
