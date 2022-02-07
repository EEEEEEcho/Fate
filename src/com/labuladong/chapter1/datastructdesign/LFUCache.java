package com.labuladong.chapter1.datastructdesign;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 关键在于构造一个有序且维护插入时顺序的数据结构
 */
public class LFUCache {
    //key到val的映射，称为KV表，对应键和值
    private HashMap<Integer,Integer> keyToValue;
    //key到freq的映射，称为KF表，对应键和频率
    private HashMap<Integer,Integer> keyToFreq;
    //出现频率和该出现频率相同的键的集合对应表，称为FK表
    private HashMap<Integer,LinkedHashSet<Integer>> freqToKeys;
    //容量
    private int cap;
    //最小频率
    private int min;

    public LFUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.min = 0;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        //增加这个key被访问的频率
        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;
        //key存在，
        if (keyToValue.containsKey(key)){
            //如果有，更新，增加访问频率
            keyToValue.put(key,value);
            increaseFreq(key);
            return;
        }
        //key不存在，插入，如果容量满了，淘汰一个最小的
        if (keyToValue.size() >= this.cap){
            removeMinKey();
        }
        //插入kv表
        keyToValue.put(key,value);
        //插入kf表
        keyToFreq.put(key,1);
        //插入fk表
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入新key之后，最小的freq肯定是1
        this.min = 1;
    }

    private void increaseFreq(int key){
        //更新KF表
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key,freq + 1);
        //更新FK表
        //从原来的频率列表中删除
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1,new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        if (freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //如果这个freq恰好是最小的freq
            if (freq == this.min){
                this.min ++;
            }
        }
    }

    private void removeMinKey(){
        //freq最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.min);
        //最先被插入的key就是最先要被淘汰的
        Integer keyToDelete = keyList.iterator().next();
        keyList.remove(keyToDelete);
        if (keyList.isEmpty()){
            freqToKeys.remove(this.min);
        }
        keyToValue.remove(keyToDelete);
        keyToFreq.remove(keyToDelete);
    }

    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(3,3);
        treeMap.put(2,2);
        System.out.println(treeMap);
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstKey());
    }
}
