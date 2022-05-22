package com.base.basics.knowledge;

/**
 * 存在继承关系的情况下类加载的顺序
 * 父类(静态变量、静态语句块)       类加载时会为静态变量赋初值，执行静态代码块，但不会执行类的静态方法，类的方法在调用时才会执行
 * 子类(静态变量、静态语句块)
 * 父类(实例变量、普通语句块)
 * 父类(构造函数,如果父类的构造函数中调用的方法被子类重写，那么调用的会是子类的方法)
 * 子类(实例变量、普通语句块)
 * 子类(构造函数)
 */
public class Parent {
    private String name = "parent";

    public Parent(){
        show();
    }

    public void show(){
        System.out.println("parent:" + name);
    }

    public static void main(String[] args) {
        new Child();
        //child:null        //这里父类构造函数调用的是子类重写的方法，因为这时子类还没有初始化，所以name字段的值为null
        //child:child
    }
}

class Child extends Parent{
    private String name = "child";
    public Child(){
        show();
    }
    public void show(){
        System.out.println("child:" + name);
    }
}
