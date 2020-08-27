package com.theswordreferstooffer.offer;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LuckyNumber {
    /**
     * 已知1000个硬币里有10个硬币，随机取出n个硬币，则取出的硬币里有金币的概率是多少
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n > 990){
            System.out.println("1.000000");
        }
        else{
            double a1 = 1;
            double a2 = 1;
            if(n <= 10){
                for(int i = 0;i < n;i ++){
                    a1 *= 990 - i;
                    a2 *= 1000 - i;
                }
            }
            else{
                for(int i=0;i < 10;i ++){
                    a1 *= (990 -n + i);
                    a2 *= (1000 - n + i);
                }
            }
            double re = 1 - a1 / a2;
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println(df.format(re));
        }
    }
}
