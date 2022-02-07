package com.thinkInJava.chapter11;

import java.util.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("WO","CAO","NI","MA"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println();
        for (String s : list){
            System.out.println(s);
        }
        System.out.println();
        iterator = list.iterator();
        for(int i = 0; i < list.size();i ++){
            iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }
}
