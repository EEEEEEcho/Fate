package com.thinkInJava.chapter10;

public class Outer2 {
    private String s = "hhh";
    public Outer2(){
        System.out.println(s);
    }
    private void sayHello(){
        System.out.println("Hello");
    }
    private Inner2 getInner(){
        return new Inner2();
    }
    public void getInnerS(){
        System.out.println(new Inner2().innerS);
    }
    class Inner2{
        private String innerS = " world";
        public void changeS(){
            s = "cccc";
            System.out.println(s);
        }
        public void invokeSayHello(){
            sayHello();
        }
    }

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.getInnerS();
        Inner2 inner = outer2.getInner();
        inner.changeS();
        inner.invokeSayHello();
    }
}
