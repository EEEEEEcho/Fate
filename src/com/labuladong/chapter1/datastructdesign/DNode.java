package com.labuladong.chapter1.datastructdesign;

public class DNode {
    public int key;
    public int value;
    public DNode next;
    public DNode pre;
    public DNode(int k,int v){
        this.key = k;
        this.value = v;
    }
}
