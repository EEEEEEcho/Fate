package com.base.basics.generic;

public class GenericsDemo5 {
    public static void main(String[] args) {
        Integer[] integers = func1(1, 2, 3, 4, 5, 6);
        func2(integers);
    }

    //一种讨巧的使用场景，让这个方法为我们自动生成泛型数组
    public static <T> T[] func1(T ... args){
        //返回泛型数组
        return args;
    }

    public static <T> void func2(T param[]){
        System.out.println("接收泛型数组");
        for(T t: param){
            System.out.print(t + " , ");
        }
    }
}
