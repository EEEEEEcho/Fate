package com.code.Dynamic;

public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0){
            return res;
        }
        res[1] = 1;
        if (n == 1){
            return res;
        }
        for (int i = 2; i < res.length; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public int count(int n){
        int count = 0;
        while (n > 0){
          if (n % 2 != 0){
              count ++;
          }
          n = n / 2;
        }
        return count;
    }

    /**
     * Brian Kernighan 算法
     * 对从 00 到 nn 的每个整数直接计算「一比特数」。每个int 型的数都可以用 3232 位二进制数表示，只要遍历其二进制
     * 表示的每一位即可得到 1的数目。
     * Brian Kernighan 算法的原理是：对于任意整数 xx，令 x=x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     * @param n
     * @return
     */
    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0){
            return res;
        }
        res[1] = 1;
        if (n == 1){
            return res;
        }
        for (int i = 2; i < res.length; i++) {
            res[i] = brianKernighan(i);
        }
        return res;
    }

    //题解：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
    //说白了，状态转移方程弄不出来
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public int brianKernighan(int n){
        int count = 0;
        while (n > 0){
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        int count = countBits.count(2);
        System.out.println(count);
    }
}
