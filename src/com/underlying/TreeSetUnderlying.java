package com.underlying;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetUnderlying {
    public static void main(String[] args) {
        /**
         * 1.
         */
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) (o1)).compareTo((String) o2);
            }
        });
        //添加数据
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        System.out.println(treeSet);

    }
}
