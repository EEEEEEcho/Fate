package com.thinkInJava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    /**
     * listIterator():区别于只能单向移动的iterator(),此迭代器可以双向移动，而且可以一开始就定位在
     * 某个指定的位置
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("WO","CAO","NI","MA"));
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next() + "," + listIterator.nextIndex() + ", " + listIterator.previousIndex() + ";");
        }
        System.out.println();
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        System.out.println(list);
        listIterator = list.listIterator(3);
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println(list);
    }
}
