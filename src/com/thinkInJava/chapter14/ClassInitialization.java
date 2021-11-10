package com.thinkInJava.chapter14;


import java.util.Random;

class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initiable");
    }
}
class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initiable2");
    }
}
class Initable3{
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}


public class ClassInitialization{
    public static Random random = new Random(47);

    public static void main(String[] args) throws Exception{
        Class initiable = Initable.class;       //这里只是初始化了 initiable 的Class对象的引用。 initiable对象并没有创建
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);      //Initable.staticFinal 是一个static final的常量，是编译期常量，
                                                        // 不需要对Initiable类初始化进行读取
        System.out.println(Initable.staticFinal2); //这个时候initiable被加载了，因为Initable.staticFinal2虽
                                                    // 然被static和final修饰，但它并不是一个编译期常量。所以Initable会强制初始化
        System.out.println(Initable2.staticNonFinal);   //如果一个static域不是final的，那么在对它访问时，总是要求在它被读取之前，
                                                        //要先进行链接和初始化。
        Class initable3 = Class.forName("com.thinkInJava.chapter14.Initable3");// 初始化 并加载了Initable3
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
