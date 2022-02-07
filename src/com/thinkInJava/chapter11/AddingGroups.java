package com.thinkInJava.chapter11;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        //首选方式
        Collections.addAll(collection,11,12,13,14,15,16);
        Collections.addAll(collection,moreInts);    //这就没有asList了

        //可以使用Arrays.asList()直接作为构造列表的输入，但是这种情况下，其底层表示
        //是数组，不能调整尺寸
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);
        //list.add(21); //所以尝试add或delete时，会发生异常
    }
}
