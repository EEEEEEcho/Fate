package com.base.basics.knowledge;
//在使用静态变量和方法时不用再指明 ClassName，从而简化代码，但可读性大大降低。
import static com.base.basics.Main.mainPrint;
public class StaticDemo {
    //实例变量: 每创建一个实例就会产生一个实例变量，它与该实例同生共死。
    private int x;
    //静态变量: 又称为类变量，也就是说这个变量属于类的，类所有的实例都共享静态变量，可以直接通过类名来访问它；静态变量在内存中只存在一份。
    private static int y = 123;

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        int x = staticDemo.x;
        int y = StaticDemo.y;
        System.out.println(x);
        System.out.println(y);

        //非静态内部类依赖于外部类的实例，而静态内部类不需要。
        //InnerClass innerClass = new InnerClass();   //com.base.basics.knowledge.StaticDemo.this' cannot be referenced from a static con
        InnerClass innerClass = staticDemo.new InnerClass();
//        静态内部类不能访问外部类的非静态的变量和方法。
        StaticInnerClass staticInnerClass = new StaticInnerClass();

        mainPrint();
    }

    //静态方法在类加载的时候就存在了，它不依赖于任何实例。所以静态方法必须有实现，也就是说它不能是抽象方法(abstract)。
    //只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字。
    public static void func1(){
//        int x = this.x; //编译出错
        System.out.println(y);
    }
    //静态语句块在类初始化时运行一次。
    static {
        System.out.println("Hello world" + y);
    }

    //非静态内部类依赖于外部类的实例，而静态内部类不需要。
    class InnerClass{

    }

    static class StaticInnerClass{

    }
    //存在继承的情况下，初始化顺序为:
    //父类(静态变量、静态语句块)
    //子类(静态变量、静态语句块)
    //父类(实例变量、普通语句块)
    //父类(构造函数)
    //子类(实例变量、普通语句块)
    //子类(构造函数)
}
