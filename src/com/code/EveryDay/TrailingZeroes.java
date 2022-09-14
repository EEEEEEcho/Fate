package com.code.EveryDay;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        //n! 尾零的数量即为 n! 中因子 10 的个数，而 10=2×5，因此转换成求n!中质因子 2 的个数和质因子 5 的个数的较小值。
        int count = 0;
        while (n > 0){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        int i = trailingZeroes.trailingZeroes(30);
        System.out.println(i);
    }
}
