package com.code.BitMultiplication;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        for(int i = 0;i < 32;i ++){
            if((mask & x) != (mask & y)){
                count ++;
            }
            mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int tmp = 4;
        while (tmp > 0){
            System.out.println(tmp >> 1);
            tmp = tmp >> 1;
        }
    }
}
