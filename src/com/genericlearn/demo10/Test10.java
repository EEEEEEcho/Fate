package com.genericlearn.demo10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 泛型与数组
 */
public class Test10 {
    public static void main(String[] args) {
        //ArrayList<String>[] lists = new ArrayList<>[5];报错
        ArrayList<String>[] lists;
        //可以声明带泛型的数组引用，不可以直接创建带泛型的数组对象

        //可以创建不带泛型的数组对象
        ArrayList[] arrayLists = new ArrayList[5];
        //然后将带泛型的数组引用赋值给它
        lists = arrayLists;

        //但是这样是有弊端的

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        arrayLists[0] = intList;

        //lists引用和arrayLists引用都指向统一个非泛型数组对象
        //然后使用lists这个带泛型的引用去访问时，发现添加的Integer类型变成了String类型
        //String s = lists[0].get(0);
        //System.out.println(s);
        //出现异常 ： java.lang.Integer cannot be cast to java.lang.String

        //所以泛型数组时，应该这样定义
        ArrayList<String>[] listArrayStr = new ArrayList[5];
        //listArrayStr[0] = intList; 会直接报错，进行泛型检查

        //可以通过java.lang.reflect.Array的newInstance(Class<T>,int)创建T[]数组
        Fruit<String> fruit = new Fruit<>(String.class,5);
        fruit.put(0,"Hello");
        fruit.put(1,"world");
        System.out.println(fruit.get(1));
        System.out.println(Arrays.toString(fruit.getArray()));
    }
}
