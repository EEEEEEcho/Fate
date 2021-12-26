package com.labuladong.chapter1.datastructdesign;

import java.util.HashMap;

public class LRUCache2 {
    private int capacity = 0;
    private HashMap<Integer,DNode> hashMap = new HashMap<>();
    private DoubleList list = new DoubleList();
    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        makeRecently(key);
        return hashMap.get(key).value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)){
            deleteKey(key);
            addRecently(key,value);
        }
        else{
            if (capacity == list.getSize()){
                removeLeastRecently();
            }
            addRecently(key,value);
        }
    }

    private void makeRecently(int key){
        DNode dNode = hashMap.get(key);
        //先从链表中删除
        list.remove(dNode);
        //然后添加到链表尾
        list.addLast(dNode);
    }

    private void addRecently(int key,int val){
        DNode dNode = new DNode(key, val);
        list.addLast(dNode);
        hashMap.put(key,dNode);
    }

    private void deleteKey(int key){
        DNode dNode = hashMap.get(key);
        list.remove(dNode);
        hashMap.remove(key);
    }

    private void removeLeastRecently(){
        //删除最久未使用的元素
        DNode dNode = list.removeFirst();
        hashMap.remove(dNode.key);
    }
}
