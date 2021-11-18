package com.code.Dynamic;

public class ClimbStairs {
    public int climbStairs(int n) {
        int x = 1;
        int y = 2;
        if (n == 1){
            return x;
        }
        else if(n == 2){
            return y;
        }
        else{
            int result = 0;
            for (int i = 3; i < n + 1; i++) {
                int tmp = y;
                result = x + y;
                x = y;
                y = result;
            }
            return result;
        }
    }
}
