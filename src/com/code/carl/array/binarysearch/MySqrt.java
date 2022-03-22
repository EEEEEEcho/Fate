package com.code.carl.array.binarysearch;

import java.math.BigInteger;

public class MySqrt {
    //乘法溢出，用除法啊。。。
    public int mySqrt1(int x) {
        if(x == 0) return 0;
        if (x >= 1 && x <= 3) return 1;
        if (x >= 4 && x <= 8) return 2;
        int left = 1;
        int right = x / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            BigInteger pow = new BigInteger(String.valueOf(mid)).multiply(new BigInteger(String.valueOf(mid)));
            BigInteger num = new BigInteger(String.valueOf(x));
            if(pow.compareTo(num) == 0){
                return mid;
            }
            else if(pow.compareTo(num) > 0){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
    //用除法解决越界
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if (x >= 1 && x <= 3) return 1;
        if (x >= 4 && x <= 8) return 2;
        int left = 1;
        int right = x / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid == x / mid){
                return mid;
            }
            else if(x / mid < mid){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int i = mySqrt.mySqrt(2147395599);
        System.out.println(i);
    }
}
