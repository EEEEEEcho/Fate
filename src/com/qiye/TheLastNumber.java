package com.qiye;

import java.util.Scanner;

public class TheLastNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long range = n - n /10;     //缩小寻找的范围
        long save = range;
        long tmp;
        while (true){
            tmp = save;
            while (tmp >= 1){
                //System.out.println(tmp);
                tmp /= 10;
                range += tmp;
            }
            if(n == range){
                System.out.println(save);
                break;
            }
            else if(range < n){
                save ++;
                range = save;
            }
            else {
                System.out.println("-1");
                break;
            }
        }
    }
}
