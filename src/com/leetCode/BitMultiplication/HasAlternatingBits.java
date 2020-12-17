package com.leetCode.BitMultiplication;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if (n == 1){
            return true;
        }
        int length = 0;
        int tmp = n;
        while (tmp > 0){
            tmp >>= 1;
            length ++;
        }
        int mask = 1;
        boolean isZero = (mask & n) == 0;
        mask <<= 1;

        for(int i = 1;i < length;i ++){
            int s = n & mask;
            if((s == 0 && isZero) || (s != 0 && !isZero)){
                return false;
            }
            isZero = (s == 0);
            mask <<= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        HasAlternatingBits h = new HasAlternatingBits();
        System.out.println(h.hasAlternatingBits(7));
    }
}
