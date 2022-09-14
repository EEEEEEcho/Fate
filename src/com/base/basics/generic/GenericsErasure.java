package com.base.basics.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class GenericsErasure {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add("Hello");
        l2.add(123);
        //结果为true。说明泛型类型String和Integer都被擦除掉了，只剩下原始类型。
        System.out.println(l1.getClass() == l2.getClass());

        //通过反射，强制给l2添加一个字符串类型的元素
        l2.getClass().getMethod("add",Object.class).invoke(l2,"World");
        //当我们利用反射调用add()方法的时候，却可以存储字符串，这说明了Integer泛型实例在编译之后被擦除掉了，只保留了原始类型
        //ArrayList被擦除类型后，原始类型也变为Object，所以通过反射我们就可以存储字符串了。
        for (int i = 0;i < l2.size();i ++){
            System.out.println(l2.get(i));
        }
        //有上下界限定的<T extends Number>,<T super Number> 会被擦除为他们的上、下限类型，即“最大”的那个类型
        //<T extends Number> 会被擦除为Number类型，<T super Number>会被擦除为Object类型
        //无任何限定的，会被直接擦除为Object类型  <T>  <?> 直接擦除为Object
        //原始类型，就是被擦除后保留的类型，如上述的  <T>被擦除后的Object
    }

}
