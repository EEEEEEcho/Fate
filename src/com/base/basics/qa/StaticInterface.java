package com.base.basics.qa;

public interface StaticInterface {
    public static int time = 10;
    public static void goodBye(){
        System.out.println("Goog Bye");
    }
    default void hello(){
        System.out.println("hello world");
    }
}
class StaticInterfaceImpl implements StaticInterface{

}