package com.code.ArrayTrain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyHashSet {

    /**
     * 我设计的
     */
//    private LinkedList<Integer> list;
//    /** Initialize your data structure here. */
//    public MyHashSet() {
//        list = new LinkedList<>();
//    }
//
//    public void add(int key) {
//        if (!list.contains(key)){
//            list.add(key);
//        }
//    }
//
//    public void remove(int key) {
//        list.remove((Integer) key);
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        return list.contains(key);
//    }
    /**
     * 链地址法
     */
    /** Initialize your data structure here. */
    private static final int BASE = 769;
    private LinkedList<Integer>[] linkedLists;
    public MyHashSet() {
        linkedLists = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            linkedLists[i] = new LinkedList<Integer>();
        }
    }

    private int hash(int key){
        return key % BASE;
    }

    public void add(int key) {
        int index = hash(key);
        ListIterator<Integer> iterator = linkedLists[index].listIterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if (element == key){
                return;
            }
        }
        linkedLists[index].addLast(key);
    }

    public void remove(int key) {
        int index = hash(key);
        ListIterator<Integer> iterator = linkedLists[index].listIterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if (element == key){
                linkedLists[index].remove((Integer) key);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        ListIterator<Integer> iterator = linkedLists[index].listIterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if (element == key){
                return true;
            }
        }
        return false;
    }
}
