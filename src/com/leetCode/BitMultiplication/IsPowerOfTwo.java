package com.leetCode.BitMultiplication;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        long x = 0;
        int count = 0;
        while (x < n){
            x = (long)Math.pow(2,count);
            count ++;
            System.out.println(x);
            if (x == n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        boolean flg = isPowerOfTwo.isPowerOfTwo(2147483647);
        System.out.println(flg);
    }
}
