package com.code.topOnehundred;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        int x = 1;
        int y = 2;
        int count = n - 2;
        while (count > 0){
            int tmp = y;
            y = x + y;
            x = tmp;
            count --;
        }
        return y;
    }
}
