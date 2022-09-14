package com.code.carl.dp;

public class FibNumber {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int p1 = 0;
        int p2 = 1;
        for(int i = 2;i <= n;i ++){
            int tmp = p2;
            p2 = p1 + p2;
            p1 = tmp;
        }
        return p2;
    }
}
