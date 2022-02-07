package com.labuladong.chapter2.binarytree;

import com.echo.B;

import java.math.BigInteger;

public class NumTrees {
    private int memo[][];
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1,n);
    }
    public int count(int low,int high){
        if (low > high) return 1;
        if (memo[low][high] != 0){
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low,i - 1);
            int right = count(i + 1,high);
            res += left * right;
            memo[low][high] = res;
        }
        return res;
    }

    /**
     * 动态规划
     * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     *  当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
     *  f(i)=G(i−1)∗G(n−i)
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     * @param n
     * @return
     */
    public int numTrees2(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //f(i)=G(i−1)∗G(n−i)
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees3(int n){
        BigInteger c0 = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            c0 = c0.multiply(new BigInteger("4"));
            c0 = c0.multiply(new BigInteger(String.valueOf(i)));
            c0 = c0.subtract(new BigInteger("2"));
            c0 = c0.divide(new BigInteger(String.valueOf(i + 1)));
        }
        return Integer.parseInt(c0.toString());
    }

    public static void main(String[] args) {
        NumTrees n = new NumTrees();
        int i = n.numTrees3(19);
        System.out.println(i);
//        int tmp = 6;
//        int count = 3;
//        int x = 1;
//        while (count > 0){
//            x *= tmp;
//            tmp --;
//            count --;
//        }
//        System.out.println(x);
    }
}
