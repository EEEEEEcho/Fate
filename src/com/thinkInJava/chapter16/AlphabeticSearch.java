package com.thinkInJava.chapter16;

import java.util.Arrays;

public class AlphabeticSearch {
    public static void main(String[] args) {
        String sa[] = new String[]{
                "asdasdc","dwvxvre","cvrrfd","dswtg","mborhw","pljfid","lmjhu","yefg","fkgl",
                "DEWF","BRED","NBURE","UORWL","ITELF","RFWGV","VOEG"
        };
        //注意，使用了String.CASE_INSENSITIVE_ORDER这个Comparator.
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        //这里就要在查找时也使用这个Comparator
        int index = Arrays.binarySearch(sa,sa[sa.length - 1],String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index : " + index + "\n" + sa[index]);
    }
}
