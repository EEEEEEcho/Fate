package com.thinkInJava.chapter20;

public class AssertDemo {
    static int i = 5;
    public static void main(String[] args) {
        assert i == 6;
        System.out.println("断言成功则打印此句");
//        断言需要开启
//        在VM arguments输入-ea就是开启（enableassertion）输入-da就是关闭（disenableassertion）
    }
}
