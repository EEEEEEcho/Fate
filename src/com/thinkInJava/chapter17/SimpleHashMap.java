package com.thinkInJava.chapter17;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    //选择一个大质数作为hash表的长度
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key,V value){
        V oldValue = null;
        //将key的值做hash然后取余SIZE，求出散列的位置
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        //找到位置
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        //存在,就用新值替换旧值
        while (it.hasNext()){
            if (pair.getKey().equals(key)){
                oldValue = pair.getValue();
                it.set(pair);   //用新值替换旧值
                found = true;
                break;
            }
        }
        //不存在，就新建一个
        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for(MapEntry<K,V> pair: buckets[index]){
            if (pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket == null){
                continue;
            }
            for (MapEntry<K,V> pair: bucket){
                set.add(pair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
