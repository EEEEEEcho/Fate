package com.labuladong.chapter4.dynamic;

public class MaxProfit {
    //121题，只能交易一次
    public int maxProfit1(int[] prices) {
        //dp[i][k][0] = max(dp[i - 1][k][0],dp[i - 1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i - 1][k][1],dp[i - 1][k - 1][0] - prices[i])
        //边界条件
        //dp[-1][...][0] = 0
        //dp[-1][...][1] = Integer.MIN_VALUE
        //dp[...][0][0] = 0
        //dp[...][0][1] = Integer.MIN_VALUE

        //映射到本题： k = 1
        //dp[i][1][0] = max(dp[i - 1][1][0],dp[i - 1][1][1] + prices[i])
        //dp[i][1][1] = max(dp[i - 1][1][1],dp[i - 1][0][0] - prices[i])
        //由于dp[...][0][0] = 0， 可以化简
        //dp[i][1][1] = max(dp[i - 1][1][1], -prices[i])
        //因为所有的k都为1，继续化简
//        int n = prices.length + 1;
//        int[][] dp = new int[n][2];
//        dp[0][0] = 0;
//        dp[0][1] = Integer.MIN_VALUE;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
//        }
//        return dp[n - 1][0];
        //状态压缩，新状态只和相邻状态有关系
        int n = prices.length + 1;
        int x = 0;
        int y = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            x = Math.max(x,y + prices[i - 1]);
            y = Math.max(y, -prices[i - 1]);
        }
        return x;
    }
    //122题，对交易次数没有限制 k为无穷大
    public int maxProfit2(int[] prices) {
//        int n = prices.length + 1;
//        int[][][] dp = new int[n][n][2];
//        //初始条件
//        for (int i = 0; i < n; i++) {
//            dp[0][i][1] = Integer.MIN_VALUE;
//            dp[i][0][1] = Integer.MIN_VALUE;
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i - 1]);
//                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i - 1]);
//            }
//        }
//        return dp[n - 1][n - 1][0];
        //k为无穷大，那么k这个限制条件可以优化掉
//        int n = prices.length + 1;
//        int [][] dp = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 0;
//            dp[i][1] = Integer.MIN_VALUE;
//        }
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
//        }
//        return dp[n - 1][0];
        //状态压缩
        int n = prices.length + 1;
        int x = 0;
        int y = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            x = Math.max(x,y + prices[i - 1]);
            y = Math.max(y,x - prices[i - 1]);
        }
        return x;
    }
    //123题，对交易的次数有限制，K为2
    public int maxProfit3(int[] prices) {
//        int n = prices.length + 1;
//        int k = 2;
//        int[][][] dp = new int[n][k + 1][2];
//        for (int i = 0; i < k + 1; i++) {
//            dp[0][i][0] = 0;
//            dp[0][i][1] = Integer.MIN_VALUE;
//        }
//        for (int i = 0; i < n; i++) {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Integer.MIN_VALUE;
//        }
////        for (int i = 1; i < n; i++) {
////            for (int j = 1; j < k + 1; j++) {
////                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i - 1]);
////                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i - 1]);
////            }
////        }
//        for (int i = 1; i < n; i++) {
//            dp[i][2][0] = Math.max(dp[i - 1][2][0],dp[i - 1][2][1] + prices[i - 1]);
//            dp[i][2][1] = Math.max(dp[i - 1][2][1],dp[i - 1][1][0] - prices[i - 1]);
//        }
//        return dp[n - 1][k][0];
        //状态压缩
        int n = prices.length + 1;
        int dp_i10 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i10 = Math.max(dp_i10,dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11,- prices[i]);
            dp_i20 = Math.max(dp_i20,dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21,dp_i10 - prices[i]);
        }
        return dp_i20;
    }

    //188 指定最大交易次数
    public int maxProfit4(int k, int[] prices) {
        int n = prices.length + 1;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[n - 1][k][0];
    }

    //309 含冷冻期
    public int maxProfit5(int[] prices) {
        int n = prices.length + 1;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = Math.max(dp[0][0],dp[0][1] + prices[0]);
        dp[1][1] = Math.max(dp[0][1],- prices[0]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i - 1]);
        }
        return dp[n - 1][0];
    }
    //714 含手续费,无限次交易，忽略K
    public int maxProfit6(int[] prices, int fee) {
//        int n = prices.length + 1;
//        int[][] dp = new int[n][2];
//        dp[0][1] = Integer.MIN_VALUE;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i - 1] - fee);
//        }
//        return dp[n - 1][0];
        //状态压缩
        int n = prices.length + 1;
        int [][] dp = new int[n][2];
        dp[0][1] = Integer.MIN_VALUE;
        int x = 0;
        int y = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            x = Math.max(x,y + prices[i - 1]);
            y = Math.max(y,x - prices[i - 1] - fee);
        }
        return x;
    }
}
