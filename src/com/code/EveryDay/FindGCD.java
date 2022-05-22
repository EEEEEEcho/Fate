package com.code.EveryDay;

import java.util.Scanner;

public class FindGCD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int gcd = gcd(m,n);
        int lcm = lcm(gcd, m * n);
        System.out.println("最大公约数为: " + gcd + ", 最小公倍数为: " + lcm);
        scanner.close();
    }


    //两数乘积除以最大公约数就是最小公倍数
    public static int lcm(int gcd,int mul){
        return mul / gcd;
    }

    //辗转相除法求最大公约数
    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
