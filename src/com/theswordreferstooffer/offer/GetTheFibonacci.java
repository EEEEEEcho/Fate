package com.theswordreferstooffer.offer;

public class GetTheFibonacci {
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }
    public long Fibonacci1(int n){
        long result = 0;
        long one = 1;
        long two = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for(int i=2;i <= n;i ++){
            result = one + two;
            two = one;
            one = result;
        }
        return result;
    }
}
