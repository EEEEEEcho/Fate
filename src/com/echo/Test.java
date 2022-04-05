package com.echo;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s1 = "Javatpoint";           //常量池里。
        String s2 = s1.intern();        //看常量池里有没有s1的串，有就不加入了，让s2也指向它，否则在常量池中加入该串并让s2指向它
        String s3 = new String("Javatpoint");   //堆里
        String s4 = s3.intern();    //看常量池里有没有s3的串，有就不加入了，让s4也指向它，否则在常量池中加入该串并让s4指向它
        System.out.println(s1==s2); // True 常量池 = 常量池
        System.out.println(s1==s3); // False 常量池 != 堆
        System.out.println(s1==s4); // True  常量池 = 常量池
        System.out.println(s2==s3); // False 常量池 != 堆
        System.out.println(s2==s4); // True 常量池 = 常量池
        System.out.println(s3==s4); // False 堆 != 常量池

    }
}
