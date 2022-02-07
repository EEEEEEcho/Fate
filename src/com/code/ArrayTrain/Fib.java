package com.code.ArrayTrain;

public class Fib {
    public int fib(int n) {
        int f1 = 1;
        int f2 = 1;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return f1;
        }
        if (n == 2){
            return f2;
        }
        int result = 0;
        int i = 3;
        while (i <= n){
            result = f2 + f1;
            f1 = f2;
            f2 = result;
            i++;
        }
        return result;
    }
}
