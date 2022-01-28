package com.underlying;

import com.proxyStudy.staticProxy.Student;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet<>();
        //LinkedHashSet底层维护的是一个LinkedHashMap(是HashMap的子类)
        //LinkedHashSet底层结构（数组table + 双向链表)
        //第一次添加时，直接将数组table扩容到16，存放的节点类型是LinkedHashMap$Entry
        //数组是HashMap$Node[]，存放的元素/数据是 LinkedHashMap$Entry
        //继承关系发生在内部类继承
        //static class Entry<K,V> extends HashMap.Node<K,V> {
    //        Entry<K,V> before, after; //这两个属性是用来实现双向链表的结构的
    //        Entry(int hash, K key, V value, Node<K,V> next) {
    //            super(hash, key, value, next);
    //        }
    //    }
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Student("Echo"));
        set.add(123);
        set.add("HSP");

    }
}
