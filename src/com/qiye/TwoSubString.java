package com.qiye;

import java.util.Scanner;

public class TwoSubString {
    public static void main(String[] args) {
        /**
         * 思路：abracadabra 前面从头开始到倒数第一个abracadabr 跟从第二个开始到最后一个bracadabra 比较。如果匹配那么
         * 最大的匹配长度 就是 这个字串的长度从这个长度开始往后截就是要拼接的长度 以此类推
         abracadabr
         bracadabra
         abracadab
         racadabra
         abracada
         acadabra
         abracad
         cadabra
         abraca
         adabra
         abrac
         dabra
         abra
         abra
         abr
         bra
         ab
         ra
         a
         a
         找到最长匹配的
         */
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int max = 0;
        for(int i=s1.length() - 1;i >= 1;i --){
            String tmp1 = s1.substring(0,i) + "";
            //System.out.println(tmp1);
            String tmp2 = s1.substring(s1.length() - i) + "";
            //System.out.println(tmp2);
            //System.out.println(tmp1.equals(tmp2));
            if(tmp1.equals(tmp2)){
                max = Math.max(tmp1.length(),max);
            }
        }
        //System.out.println("abr1" == "abra");
        System.out.println(s1 + s1.substring(max));
    }
}
