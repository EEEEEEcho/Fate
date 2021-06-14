package com.genericlearn.demo04;

public class Test04 {
    public static void main(String[] args) {
        ChildFirst<String> childFirst = new ChildFirst<>();
        childFirst.setValue("abc");
        String value = childFirst.getValue();
        System.out.println(value);

        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue("hello world");
        String value1 = childSecond.getValue();
        System.out.println(value1);
    }
}
