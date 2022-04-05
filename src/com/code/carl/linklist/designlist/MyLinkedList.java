package com.code.carl.linklist.designlist;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class MyLinkedList {
    private DoubleList doubleList;

    public MyLinkedList() {
        doubleList = new DoubleList();
    }

    public int get(int index) {
        return doubleList.node(index) == null ? -1 : doubleList.node(index).val;
    }

    public void addAtHead(int val) {
        doubleList.addHead(new Node(val));
    }

    public void addAtTail(int val) {
        doubleList.addTail(new Node(val));
    }

    public void addAtIndex(int index, int val) {
        doubleList.add(new Node(val),index);
    }

    public void deleteAtIndex(int index) {
        doubleList.delete(index);
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.get(0) + ":" + myLinkedList.get(1));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1) + " : " + myLinkedList.get(2));
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
    }
}

class DoubleList{
    Node head;
    Node tail;
    int size;
    public DoubleList(){
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void addTail(Node node){
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        size ++;
    }
    public void addHead(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        size ++;
    }
    public void add(Node node,int index){
        if (index <= 0){
            addHead(node);
        }
        else if(index == size){
            addTail(node);
        }
        else if(index < size){
            Node postNode = node(index);
            node.next = postNode;
            node.pre = postNode.pre;
            postNode.pre.next = node;
            postNode.pre = node;
            size ++;
        }
    }

    public void delete(int index){
        if (index >= 0 && index < size){
            Node postNode = node(index);
            postNode.pre.next = postNode.next;
            postNode.next.pre = postNode.pre;
            size --;
        }
    }

    public Node node(int index){
        if (index < 0 || index > size - 1) return null;
        int mid = size >> 1;
        if (index < mid){
            Node x = head;
            for (int i = 0; i <= index; i++) {
                x = x.next;
            }
            return x;
        }
        else{
            Node x = tail;
            for (int i = size - 1; i >= index ; i--) {
                x = x.pre;
            }
            return x;
        }
    }
}

class Node{
    int val;
    Node pre;
    Node next;
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
}
