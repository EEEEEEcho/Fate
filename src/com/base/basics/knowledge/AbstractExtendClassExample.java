package com.base.basics.knowledge;

/**
 * 抽象类和抽象方法都使用 abstract 关键字进行声明。抽象类一般会包含抽象方法，
 * 抽象方法一定位于抽象类中
 * 抽象类与非抽象类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类
 */
public class AbstractExtendClassExample extends AbstractClassExample{
    @Override
    public void func1() {
        System.out.println("func1()" + super.x);
    }

    public static void main(String[] args) {
        AbstractClassExample a = new AbstractExtendClassExample();
        a.func1();
        a.func2();
    }
}
