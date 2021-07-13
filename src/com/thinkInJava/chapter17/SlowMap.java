package com.thinkInJava.chapter17;

import java.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V>{
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public V get(Object key){
        if(!keys.contains(key)){
            return null;
        }
        //key对应的位置就是value对应的位置
        return values.get(keys.indexOf(key));
    }

    public V put(K key,V value){
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }
        else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> slowMap = new SlowMap<>();
        slowMap.putAll(Countries.capitals(15));
        System.out.println(slowMap);
        System.out.println(slowMap.get("BURUNDI"));
        System.out.println(slowMap.entrySet());
    }
}
