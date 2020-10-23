package com.thinkInJava.chapter17;

import com.thinkInJava.chapter16.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        //记住，CollectionData本身就是一个List容器。
        //所以其他类型List容器可以接收它作为参数。
        System.out.println(new ArrayList<String>(
                CollectionData.list(new RandomGenerator.String(9),10)
        ));

        System.out.println(new HashSet<Integer>(
                new CollectionData<>(new RandomGenerator.Integer(),10)
        ));
    }
}
