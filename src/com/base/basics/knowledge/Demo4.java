package com.base.basics.knowledge;
// class只可以被public 或者默认不加任何修饰符修饰
public class Demo4 {
    public static void main(String[] args) {
        //这样会报错，因为1.1作为字面量是被编译器认为是double类型的。
        //这样赋值，其实是发生了类型向下的强制类型转换，这种类型转换只能是主动声明式的
//        float f = 1.1;

        //正确赋值
        float f1 = 1.1f;
        //强制类型转化，丢失精度
        float f2 = (float) 1.1;

        //隐式类型转换也可能发生在int身上
        short s1 = 1;
        //这样会报错，字面量1是int类型，它比 short 类型精度要高，因此不能隐式地将 int 类型下转型为 short 类型
//        s1 = s1 + 1;
//        但是使用 += 运算符可以执行隐式类型转换。
        s1 += 1;
        //上语句相当于将 s1 + 1 的计算结果进行了向下转型s1 = (short) (s1 + 1);
    }
}
