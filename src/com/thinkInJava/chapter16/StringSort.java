package com.thinkInJava.chapter16;

import java.util.Arrays;
import java.util.Collections;

public class StringSort {
    public static void main(String[] args) {
        String sa[] = new String[]{
                "asdasdc","dwvxvre","cvrrfd","dswtg","mborhw","pljfid","lmjhu","yefg","fkgl",
                "DEWF","BRED","NBURE","UORWL","ITELF","RFWGV","VOEG"
        };
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println( Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);  //忽略大小写
        System.out.println(Arrays.toString(sa));
        //jAVA中的排序方式，：对基本类型，快排。对对象类型，稳定归并
    }
}
