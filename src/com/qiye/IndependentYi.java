package com.qiye;

import java.util.Scanner;

public class IndependentYi {
    static int x;
    static int p;
    public static int getMaxDay(int f,int d){
        int maxDay = d / x;
        if(maxDay <= f){
            return maxDay;
        }
        else{
            //change为所有钱减去房租钱以后剩余的部分
            int change = d - maxDay * x;
            //剩余的钱为left
            int left = 0;
            //如果减去房租后的钱仍然够买水果
            if(change > p){
                //那么剩余的钱买水果
                f += change/p;
            }
            else{
                //否则的话就是不够买水果了
                left = change;
            }
            int t = 0;
            //如果房租 比水果贵
            if(x >= p){
                t = 1;
            }
            else{
                //否则的话，t表示买一个水果可以少交几天房租
                t = p/x;
            }
            while (maxDay > f){
                if(maxDay < f + t){
                    //最大生存天数 比起水果数和买完水果后少活的天数要小
                    t = 1;
                }
                //少交t天的房租
                maxDay -= t;
                //剩下的钱就是 房租数乘以少交的天数
                left += x * t;
                //留着这钱没用，买水果吧
                f += left / p;
                left -= p * (left / p);
            }
            return maxDay;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();
        p = scanner.nextInt();
        System.out.println(getMaxDay(f,d));
    }
}
