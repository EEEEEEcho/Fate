package com.code.Dynamic;

public class Tribonacci {
    public int tribonacci(int n) {
        int x = 0;
        int y = 1;
        int z = 1;
        if (n == 0){
            return x;
        }
        else if(n == 1){
            return y;
        }
        else if(n == 2){
            return z;
        }
        else{
            int result = 0;
            for (int i = 3; i <= n ; i++) {
                int tmp1 = y;
                int tmp2 = z;
                result = x + y + z;
                x = tmp1;
                y = tmp2;
                z = result;
            }
            return result;
        }
    }
}
