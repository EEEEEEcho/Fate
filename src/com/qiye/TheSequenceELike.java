package com.qiye;

import java.util.Scanner;

public class TheSequenceELike {
    /**
     * 说真的 我真的不会动态规划，基本思想还是有的，一个一个放，然后除去那些不合格的
     * 借鉴大佬的
     */
    public static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int dp[][] = new int[n+1][k+1];
        dp[0][1] = 1;

        for(int i=1;i <=n; i++){
            /**
             * 先把所有符合条件的找出来，当前新加一个数字之后符合条件的数目依赖于原来不添加新数字时符合条件的数目
             */
            int sum = 0;
            for(int j = 1;j <= k;j ++){
                sum += dp[i-1][j];
                sum %= mod;
            }

            /**
             * 过滤那些不符合条件的
             * 即不满足(A <= B)或(A mod B != 0)
             * 这个条件怎么理解呢? 其实就是如果前一个数是当前数的倍数且比当前数大，
             * 那肯定就是不符合情况，当然不符合条件的数列的数量是之前所有不符合条件的数量
             * 比如【1，2】  【1，2，1】
             */
            for(int x = 1;x <= k;x ++){
                int filtter = 0;
                for(int y = x + x; y <= k; y += x){
                    filtter += dp[i-1][y];
                    filtter %= mod;
                }
                //滤掉所有不符合的情况 看作 sum - filter
                dp[i][x] = (sum - filtter + mod) % mod;
            }
        }
        int result = 0;
        //最后一行就是所有符合情况的
        for(int i=1;i <=k;i ++){
            result += dp[n][i];
            result %= mod;
        }
        System.out.println(result);
    }
}
