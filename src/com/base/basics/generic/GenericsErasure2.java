package com.base.basics.generic;

public class GenericsErasure2 {

    public static void main(String[] args) {


//        在调用泛型方法时，可以指定泛型，也可以不指定泛型:
//        在不指定泛型的情况下，泛型变量的类型为该方法中的几种类型的同一父类的最小级，直到Object
//        在指定泛型的情况下，该方法的几种类型必须是该泛型的实例的类型或者其子类

        /**不指定泛型的时候*/
        int i = GenericsErasure2.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f = GenericsErasure2.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o = GenericsErasure2.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

        /**指定泛型的时候*/
        int a = GenericsErasure2.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
        //int b = GenericsErasure2.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
        Number c = GenericsErasure2.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }

    //通过泛型实例化对象的方法
    public static <T> T newClass(Class<T> clazz) throws Exception{
        T instance = clazz.newInstance();
        return instance;
    }
}
