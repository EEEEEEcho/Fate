package com.code.carl.dp;

public class ZeroOneBag {
    public static void main(String[] args) {
        ZeroOneBag zeroOneBag = new ZeroOneBag();
        int i = zeroOneBag.zeroOneBag(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
        System.out.println(i);
    }
    public int zeroOneBag(int[] weights,int[] values,int bagSize){
//        int m = values.length;
//        int n = bagSize;
//        //要初始化为n + 1是因为有重量为0的情况
//        //dp[i][j]表示从0 ~ i-1个物品中选，放到容量为j的背包中获取的最大的价值
//        int[][] dp = new int[m][n + 1];
//        //无论哪个物品，放到容量为0的背包中最大价值肯定是0
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 0;
//        }
//        //只有0号物品，当背包的容量大于第0号物品的重量时，能获得的最大价值都是第0号物品的价值
//        for (int j = weights[0];j <= bagSize;j ++){
//            dp[0][j] = values[0];
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                //第i号物品的重量大于当前背包的容量，不取
//                if (weights[i] > j){
//                    dp[i][j] = dp[i - 1][j];
//                }
//                else{
//                    //第i号物品的重量小于当前背包容量
//                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weights[i]] + values[i]);
//                }
//            }
//        }
//        return dp[m - 1][n];

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < values.length; i++) {
            for (int j = bagSize; j >= weights[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - weights[i]] + values[i]);
            }
        }
        return dp[bagSize];
    }
}
