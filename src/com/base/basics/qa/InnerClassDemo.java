package com.base.basics.qa;

public class InnerClassDemo {
    private int cd = 1024;
//    private int ad = age; //外部类不能引用内部类的属性。只能通过创建内部类对象操作内部类
    private InnerClassOne innerClassOne = new InnerClassOne();
    private int ad = innerClassOne.age;

    public class InnerClassOne{
        private int age = 18;
        //内部类可以随意引用外部类的属性
        private int cod = cd;
        public int getAge() {
            return age;
        }
        public void test(){
            int a = 10;
            int b = 20;
            class MethodInnerClass{
                //一个方法内的内部类如果使用了这个方法的参数或者局部变量的话，这个参数或局部变量应该是final。
                final int field1 = a;
                final int field2 = b;
            }
            MethodInnerClass methodInnerClass = new MethodInnerClass();
            System.out.println(methodInnerClass.field1);
            System.out.println(methodInnerClass.field2);
        }
    }
    private InnerClassTwo innerClassTwo = new InnerClassTwo();
    private int bd = innerClassTwo.scd; //外部类不能引用内部类的属性。只能通过创建静态内部类对象操作内部类
    public static class InnerClassTwo{
//        private int scd = cd; 静态内部类不能引用外部类的任何属性
        private int scd = 1024;
    }

    /**
     * 静态内部类不需要有指向外部类的引用。
     * 非静态内部类需要持有对外部类的引用。
     *
     * 非静态内部类能够访问外部类的静态和非静态成员。
     * 静态内部类不能访问外部类的非静态成员，只能访问外部类的静态成员。
     * @param args
     */
    public static void main(String[] args) {
        //构造内部类对象需要提供外部类的引用
        InnerClassOne innerClassOne = new InnerClassDemo().new InnerClassOne();
        innerClassOne.test();
        //构造静态内部类对象
        InnerClassTwo innerClassTwo = new InnerClassTwo();

        InnerClassDemo.InnerClassTwo innerClassTwo1 = new InnerClassDemo.InnerClassTwo();
    }
}
