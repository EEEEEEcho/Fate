package com.code.carl.dp;

public class IntegerBreak {
    public int integerBreak(int n) {
        //1.确定dp数组的含义，dp[i]代表拆解数字i可以得到的最大乘积为dp[i]
        int[] dp = new int[n + 1];
        //2.确定递推公式
//        当 i ≥ 2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
//        将 i 拆分成 j 和 i-j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j) ；  ?
//        将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j] 。
//        因此，当 j 固定时，有 dp[i]=max(j×(i−j),j×dp[i−j])。由于 j 的取值范围是 1 到 i−1 ，需要遍历所有的 j 得到dp[i]的
        //3.初始条件
        dp[2] = 1;
        if (n <= 2){
            return dp[n];
        }
        //4.遍历顺序：明显从前向后
        for (int i = 3; i <= n; i++) {
            //从1开始到n - 1，分别计算max(j×(i−j),j×dp[i−j])
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
abstract class AbstractDemo{
    public static void main(String[] args) {

    }
}