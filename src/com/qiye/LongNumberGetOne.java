package com.qiye;

import java.util.Scanner;

public class LongNumberGetOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        String s = Long.toBinaryString(n);
        int count = 0;
        for(int i=0;i < s.length();i ++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}
