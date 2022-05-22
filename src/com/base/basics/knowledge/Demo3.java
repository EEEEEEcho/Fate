package com.base.basics.knowledge;

public class Demo3 {
    public static void main(String[] args) {
        Dog dog = new Dog("A");
        System.out.println("1 : " +  dog.getObjectAddr()); //com.base.basics.knowledge.Dog@1b6d3586
        func(dog);
        System.out.println("5 : " +  dog.getObjectAddr()); //com.base.basics.knowledge.Dog@1b6d3586
        System.out.println("6 : " +  dog.getName());
    }

    //java是值传递的，并不是引用传递，这里传递过来的一个Dog对象在内存中的地址
    public static void func(Dog dog){
        System.out.println("2 : " +  dog.getObjectAddr()); //com.base.basics.knowledge.Dog@1b6d3586
        //这里对这个dog变量的修改，其实是改变了dog变量中存储的对象的地址，将一个新的对象的地址
        //赋值给了dog变量
        dog = new Dog("B");
        System.out.println("3 : " +  dog.getObjectAddr());  //com.base.basics.knowledge.Dog@4554617c
        System.out.println("4 : " +  dog.getName());
    }
}
