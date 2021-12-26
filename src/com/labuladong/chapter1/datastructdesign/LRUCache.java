package com.labuladong.chapter1.datastructdesign;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if(value == null){
            System.out.println(map);
            return -1;
        }
        else{
            map.remove(key);
            map.put(key,value);
            System.out.println(map);
            return value;
        }

    }

    public void put(int key, int value) {
        map.remove(key);
        map.put(key,value);
        if (map.size() > capacity){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
//        cache.get(2);
//        cache.put(2,6);;
//        cache.get(1);
//        cache.put(1,5);
//        cache.put(1,2);
//        cache.get(1);
//        cache.get(2);
        cache.put(2,1);;
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);
    }
}
