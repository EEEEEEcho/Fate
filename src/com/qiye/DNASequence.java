package com.qiye;

import java.util.HashSet;
import java.util.Scanner;

public class DNASequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();
        int i,j;
        //如果一个集合放满的话，即包含所有序列的情况 集合的大小应该是 4的i次方 i为长度
        for(i=1;i <= length;i ++){
            HashSet<String> hashSet = new HashSet<>();
            for(j=0;j <= length - i;j ++){
                hashSet.add(s.substring(j,i+j));
            }
            if(hashSet.size() < Math.pow(4,i)){
                System.out.println(i);
                return;
            }
        }
    }
}
