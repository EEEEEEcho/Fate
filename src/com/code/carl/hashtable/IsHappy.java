package com.code.carl.hashtable;

import java.util.HashSet;

public class IsHappy {
    private int getNumber(int num){
        int sum = 0;
        while (num > 0){
            sum += Math.pow(num % 10,2);
            num /= 10;
        }
        return sum;
    }
    //快乐数会进入循环
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (!hashSet.contains(n)){
            if (n == 1) return true;
            hashSet.add(n);
            n = getNumber(n);
        }
        return false;
    }
}
