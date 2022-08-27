package com.code.carl.dp;

public class CompleteBag {
    public void completeBag(){
        int[] weights = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        //dp[i]表示容量为i的背包所能装下的物品的最大价值
        for (int i = 0;i < value.length;i ++){
            for (int j = weights[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j],dp[j - weights[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }

    public static void main(String[] args) {
        new CompleteBag().completeBag();
    }
}
