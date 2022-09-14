package com.interview.h3c;

public class Main3 {
    public int reverse(int x){
        boolean isNavigate = false;
        if (x < 0){
            isNavigate = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        long num = Long.parseLong(sb.reverse().toString());
        if (isNavigate){
            if (num < -Math.pow(2,31)){
                return 0;
            }else {
                return (int) -num;
            }
        }
        else {
            if (num > Math.pow(2,31) - 1){
                return 0;
            }
            else {
                return (int) num;
            }
        }
    }
}
