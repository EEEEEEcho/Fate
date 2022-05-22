package com.base.basics.qa;

public class InterfaceTestDemo {
    public InterfaceTestDemo(){
//        System.out.println();
//        super();    //调用super()必须写在子类构造方法的第一行, 否则编译不通过

        //this和super不能出现在同一个构造器中, 否则编译不通过
//        super();
//        this(); //Call to 'this()' must be first statement in constructor body

        //尽管可以用this调用一个构造器, 却不能调用2个,本质this指向本对象的指针。super是一个关键字

    }
    public static void main(String[] args) {
        //接口中可以定义静态变量,可以通过类名直接访问
        int time = StaticInterface.time;
        System.out.println(time);
        //JDK8之后接口中可以定义静态方法，可以通过类名直接访问
        StaticInterface.goodBye();
        //接口中的默认方法，只能通过创建实现了该接口的类的对象来调用。  因为，接口是不能new的。。。。。
        StaticInterface staticInterface = new StaticInterfaceImpl();
        staticInterface.hello();
        //可以通过实现类调用接口中的静态变量
        int time1 = StaticInterfaceImpl.time;
        System.out.println(time1);
        //不可以通过实现类调用接口中的静态方法
//        StaticInterfaceImpl.hello();
    }
}
