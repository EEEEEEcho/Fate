package com.thinkInJava.chapter17;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedHashMap);
        //更换为最近最少使用LRU算法，初始化linkedHashMap
        linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);
        //对前6个元素造成访问行为
        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        //然后观察顺序
        System.out.println(linkedHashMap);
        //对第一个元素造成访问行为，再观察
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }
}
