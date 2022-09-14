package com.base.basics.generic;

/**
 * 泛型类
 */
public class GenericsDemo1 {
    public static void main(String[] args) {
        Point<String> point = new Point<>();
        point.setVar("Hello");
        System.out.println(point.getVar());
    }
}
class Point<T>{
    private T var;
    public T getVar(){
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}