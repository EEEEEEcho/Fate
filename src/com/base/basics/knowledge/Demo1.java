package com.base.basics.knowledge;

public class Demo1 {
    public static void main(String[] args) {
        //new Integer(123) 每次都会新建一个对象
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);
        //Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
        Integer m = Integer.valueOf(123);
        Integer n = Integer.valueOf(123);
        System.out.println(m == n);
        //编译器会在缓冲池范围内的基本类型自动装箱过程调用 valueOf() 方法，
        //因此多个 Integer 实例使用自动装箱来创建并且值相同，那么就会引用相同的对象
        Integer p = 124;
        Integer q = 124;
        System.out.println(p == q);
    }
}
