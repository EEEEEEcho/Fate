package com.theswordreferstooffer.offer;

import java.util.Scanner;

public class Rabbits {
    /**
     * 有一对兔子，从出生后的第五个月起，每月生出一对小兔子，（即满四个月就开始生小兔），小兔子也会出生从第五个月起，每月
     * 生出一对小兔。加入兔子不会死掉，第n个月时有多少兔子
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n >=1 && n <= 4){
            System.out.println(1);
        }
        if(n >= 5 && n<=8){
            System.out.println(n - 3);
        }
        if(n >= 9){
            int start = 6;
            int j = 3;
            for(int i = n;i > 9;i --){
                start += j;
                j++;
            }
            System.out.println(start);
        }
    }
}
