package com.base.basics.qa;

public class AddDemo {
    public static void main(String[] args) {
        //a = a + b 与 a += b 的区别
        //+= 隐式的将加操作的结果类型强制转换为持有结果的类型。
        //如果两这个整型相加，如 byte、short 或者 int，首先会将它们提升到 int 类型，然后在执行加法操作。
        byte a = 127;
        byte b = 127;
//        b = a + b;      //编译出错，因为a + b 会将 a + b的结果隐式提升为int类型。  然后又将int类型赋值给了byte类型的 b
        b += a;     //b += a 会隐式的将相加结果类型强转为持有结果的类型 -> b = (byte) (a + b)

        double d = 3.14;
        //不能在没有强制类型转换的前提下将一个 double 值赋值给 long 类型的变量，因为 double 类型的范围比 long 类型更广，所以必须要进行强制转换
//        long l = d; //编译出错
        long l = (long) d;

        System.out.println(3 * 0.1 == 0.3); //false 因为有些浮点数不能完全精确的表示出来
    }
}
