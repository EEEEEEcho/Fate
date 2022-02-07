package com.genericlearn.demo09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 泛型擦除
 */
public class Test09 {
    public static void main(String[] args) {
        /**
         * 泛型是Java 1.5版本才引进的概念，在这之前是没有泛型的，
         * 但是泛型代码能够很好地和之前版本的代码兼容。那是因为，
         * 泛型信息只存在于代码编译阶段，在进入JVM之前，与泛型相
         * 关的信息会被擦除掉，我们称之为–类型擦除。
         * 类型擦除发生在由.java源代码文件生成.class字节码文件时
         */
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        System.out.println(integers.getClass().getSimpleName());
        System.out.println(strings.getClass().getSimpleName());
        System.out.println(integers.getClass() == strings.getClass());
        /**
         * 运行结果
         * ArrayList
         * ArrayList
         * true
         * 这就说明,在运行的时候,ArrayList中的泛型信息都被擦除掉了
         */
        System.out.println("------------无限制类型擦除--------------");
        Eraser<Integer> eraser = new Eraser<>();
        //反射获取当前eraser类的字节码文件的Class对象
        Class<? extends Eraser> eraserClass = eraser.getClass();
        //获取所有的成员变量
        Field[] declaredFields = eraserClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].getName() + ":" + declaredFields[i].getType().getSimpleName());
        }
        /**
         * 运行结果
         * key:Object
         * 这就证明,在我们定义这个泛型类的时候,虽然给到了它类型信息,但是在它编译为字节码文件后,通过反射
         * 再去看成员变量的数据类型时,它已经成为了Object类型.这种无限制的类型擦除直接转换为了Object类型
         */

        System.out.println("------------有限制类型擦除--------------");
        EraserLimit<Integer> eraserLimit = new EraserLimit<>();
        //反射获取当前eraser类的字节码文件的Class对象
        Class<? extends EraserLimit> eraserLimitClass = eraserLimit.getClass();
        //获取所有的成员变量
        Field[] declaredFields1 = eraserLimitClass.getDeclaredFields();
        for (int i = 0; i < declaredFields1.length; i++) {
            System.out.println(declaredFields1[i].getName() + ":" + declaredFields1[i].getType().getSimpleName());
        }
        //获取所有定义的方法
        Method[] declaredMethods = eraserLimitClass.getDeclaredMethods();
        //打印方法名字和方法的返回值类型，其中包含了定义的泛型方法
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getName() + " : " + declaredMethods[i].getReturnType().getSimpleName());
        }
        /**
         * 运行结果：
         * t:Number
         * getT : Number
         * setT : void
         * show : List
         * 在定义泛型类的时候，使用类型上限通配符给予了类型上限，所以在转换为字节码时，
         * 将类型擦除为了上限类型
         *
         * 同样的定义的泛型方法也被擦除为上限通配符中所定义的类型上限
         */

        System.out.println("----------------桥接方法-----------------");
        Class<InfoImpl> infoClass = InfoImpl.class;
        //拿到所有的方法
        Method[] declaredMethods1 = infoClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods1.length; i++) {
            System.out.println(declaredMethods1[i].getName() + " : " + declaredMethods1[i].getReturnType().getSimpleName());
        }
        /**
         * 运行结果：
         * info : Integer
         * info : Object
         * 可以发现，虽然我们只在InfoImpl中定义了一个方法，但是打印的时候有两个方法
         * 另一个info : Object就是编译器为我们生成的桥接方法。用来保持类和接口之间的实现规范
         */
    }
}
