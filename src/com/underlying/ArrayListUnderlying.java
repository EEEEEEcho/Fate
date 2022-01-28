package com.underlying;

import java.util.ArrayList;

public class ArrayListUnderlying {
    public static void main(String[] args) {
        //使用无参构造器创建ArrayList对象
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= 10 ; i++) {
//            list.add(i);
//        }
//        for (int i = 11; i <=15 ; i++) {
//            list.add(i);
//        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 8 ; i++) {
            list.add(i);
        }
        for (int i = 9; i <=15 ; i++) {
            list.add(i);
        }
        list.get(3);
    }
}
