package com.thinkInJava.chapter11;

import java.util.*;

public class CrossContainerIteration {

    public static void display(Iterator<String> iterator){
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("WO","CAO","NI","MA"));
        LinkedList<String> linkedList = new LinkedList<String>(list);
        HashSet<String> hashSet = new HashSet<String>(list);
        TreeSet<String> treeSet = new TreeSet<String>(list);
        display(list.iterator());
        display(linkedList.iterator());
        display(hashSet.iterator());
        display(treeSet.iterator());
        /**
         * 迭代器的真正威力，将遍历操作与底层结构分离
         */
    }
}
