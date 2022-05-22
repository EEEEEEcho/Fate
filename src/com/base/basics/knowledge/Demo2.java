package com.base.basics.knowledge;

public class Demo2 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        //intern() 首先把 s1 引用的对象放到 String Pool(字符串常量池)中，
        //然后返回这个对象引用。因此 s3 和 s1 引用的是同一个字符串常量池的对象。
        System.out.println(s1.intern() == s3);

        //以字面量形式定义的字符串都会放到常量池中
        String s4 = "bbb";
        String s5 = "bbb";
        System.out.println(s4 == s5);
    }
}
