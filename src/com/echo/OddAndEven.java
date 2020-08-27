package com.echo;

import java.util.Scanner;

public class OddAndEven {
    /**
     * 第一行输入一个数，为n，第二行输入n个数，这n个数中，如果偶数比奇数多，输出NO，否则输出YES。
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int oodSum = 0;
        int evenSum = 0;
        int x = 0;
        for(int i=0;i < n;i ++){
            x = input.nextInt();
            if(x % 2 == 0){
                evenSum ++;
            }
            else{
                oodSum ++;
            }
        }
        if(evenSum > oodSum){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}
