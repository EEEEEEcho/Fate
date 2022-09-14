package com.base.basics.knowledge;

public interface InterfaceExample {
    //Java8之前，接口中不允许有默认方法出现
    //Java8之后，接口中可以允许有默认方法实现
    //接口中的所有属性和方法都默认为public的，不允许定义为其他访问级别的
    //接口中的属性，都默认是static 和 final的常量
    void func1();   //等于 public void func1();

    default void func2(){
        System.out.println("func2");
    }
    int x = 123; //等于 public int x = 123;

//    int y;    //Variable 'y' might not have been initialized

    public int z = 0;

//    private int a = 0;  //Modifier 'private' not allowed here
//    protected int b = 0; //Modifier 'protected' not allowed here
//    private void func3(); //Modifier 'private' not allowed here
    //接口中也可以定义一个有具体实现的main方法
    public static void main(String[] args) {
        System.out.println("接口中定义的main方法");
    }
}
