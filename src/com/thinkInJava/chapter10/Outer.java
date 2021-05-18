package com.thinkInJava.chapter10;

public class Outer {
    private String xss = "Hello";
    class Inner{
        public Inner(String s){
            System.out.println(s);
        }
        public String xssToString(){
            return xss; //内部类访问外部类的私有成员变量
        }
        public Outer getOuter(){
            return Outer.this;  //获得外部类引用
        }
    }
    public Inner getInner(String s){
        return new Inner(s);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        //通过外部类方法创建内部类对象
        Outer.Inner inner = outer.getInner("cao");
        //通过外部类对象.new 直接创建内部类对象
        Outer.Inner inner2 = outer.new Inner("xxx");
        System.out.println(inner.xssToString());
        System.out.println(inner.getOuter());
    }
}
