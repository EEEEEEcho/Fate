package com.base.basics.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericsArray {
    public static void main(String[] args) {
//        List<String>[] list11 = new ArrayList<String>[10]; //编译错误，非法创建
//        ArrayList<String>[] lists = new ArrayList<String>[10];//编译错误，非法创建
//        List<String>[] list12 = new ArrayList<?>[10]; //编译错误，需要强转类型
        List<String>[] list13 = (List<String>[]) new ArrayList<?>[10]; //OK，但是会有警告
//        List<?>[] list14 = new ArrayList<String>[10]; //编译错误，非法创建
        List<?>[] list15 = new ArrayList<?>[10]; //OK
        List<String>[] list6 = new ArrayList[10]; //OK，但是会有警告

    }
}
