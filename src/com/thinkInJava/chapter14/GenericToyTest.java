package com.thinkInJava.chapter14;

public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        //固定了泛型，所以调用newInstance()方法时，会直接返回这个固定类型的对象
        FancyToy fancyToy = ftClass.newInstance();
        // ? super FancyToy 表示 FancyToy的父类
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
