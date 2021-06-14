package com.genericlearn.demo06;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ProductGeneator<Integer> productGeneator = new ProductGeneator<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("xxx");
        arrayList.add("bvv");
        arrayList.add("xsc");
        //泛型方法的调用，类型是通过调用方法的时候指定的
        String e = productGeneator.chooseProduct2(arrayList);
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println("----------------------------------------");
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);
        intList.add(200);
        intList.add(300);
        Integer integer = productGeneator.chooseProduct2(intList);
        System.out.println(integer + "\t" + integer.getClass().getSimpleName());
        System.out.println("----------------------------------------");
        //调用多个泛型类型的静态泛型方法
        ProductGeneator.printType(100,"jvav",true);
        //调用定义了可变参数列表的静态泛型方法
        ProductGeneator.printfVariable(1,2,3);
    }
}
