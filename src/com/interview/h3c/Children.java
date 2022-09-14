package com.interview.h3c;

public class Children extends Father{
    public void bark(){
        System.out.println("Children bark");
    }

    public void work(){
        System.out.println("Children work");
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father children = new Children();
        father.bark();
        children.bark();
        //向上转型，接口窄化
//        children.work(); 编译出错

        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        operator(sb1,sb2);
        System.out.println(sb1 + "" + sb2);
    }
    public static void operator(StringBuilder sb1,StringBuilder sb2){
        sb1.append(sb2);
        sb2 = sb1;
    }
}
