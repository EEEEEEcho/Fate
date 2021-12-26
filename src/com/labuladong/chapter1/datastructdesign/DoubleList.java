package com.labuladong.chapter1.datastructdesign;

public class DoubleList {
    //头部虚节点
    private DNode head;
    //尾部虚节点
    private DNode tail;
    //链表元素数
    private int size;

    public DoubleList(){
        head = new DNode(0,0);
        tail = new DNode(0,0);
        this.size = 0;
        head.next = tail;
        tail.pre = head;
    }

    public void remove(DNode x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        this.size --;
    }

    public void addLast(DNode x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre.next = x;
        tail.pre = x;
        this.size ++;
    }

    public DNode removeFirst(){
        if (head.next == tail) return null;
        DNode first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return this.size;
    }
}
