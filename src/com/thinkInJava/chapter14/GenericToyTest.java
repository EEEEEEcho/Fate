package com.thinkInJava.chapter14;

public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        // ? super FancyToy 表示 FancyToy的父类
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
