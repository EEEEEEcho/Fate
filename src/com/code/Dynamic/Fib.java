package com.code.Dynamic;

public class Fib {
    public int fib(int n) {
        int x = 0;
        int y = 1;
        if (n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else {
            int result = 0;
            for (int i = 2; i <= n; i++) {
                int tmp = y;
                result = x + y;
                x = tmp;
                y = result;
            }
            return result;
        }
    }
}
