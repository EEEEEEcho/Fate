package com.thinkInJava.chapter14;

public class BoundedClassReferences {
    public static void main(String[] args) {
        //此处使用? 创建了一个范围，表示任何由Number所派生的子类
        Class<? extends Number> clazz = int.class;
        clazz = double.class;
        clazz = float.class;
    }
}
