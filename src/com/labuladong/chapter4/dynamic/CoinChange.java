package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class CoinChange {
    //自顶向下：知道最终的目标，从最终的目标往下构造，说白了就是做减法
    //自顶向下一般都是要定义函数，递归构造结果
    private int[] memo; //备忘录，防止重复计算
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo,-777);//初始化备忘录，并填入特殊值
        return dp(coins,amount);
    }

    /**
     * 为了凑出目标金额amount，至少需要dp(int[] coins,int amount)方法返回值个硬币
     * @param coins 硬币列表
     * @param amount 要凑出的目标金额
     * @return 凑出相应目标金额需要的硬币个数
     */
    private int dp(int[] coins,int amount){
        if (amount == 0) return 0;  //目标金额为0，那么需要的硬币为0
        if (amount < 0) return -1;  //目标金额为负数，无解返回-1
        if (memo[amount] != -777){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            //计算子问题的结果
            int sub = dp(coins,amount - coin);
            if (sub == -1) continue;    //子问题无解，继续计算
            //在子问题中选择最优解，然后 + 1，
            //子问题 结果加一 是当前问题?
            //解释一下原因，要注意，db函数的定义是：要构造目标金额为amount，最少需要的硬币数量
            //这里 + 1，就是选择了面值为coin的硬币，需要的硬币数量 + 1
            res = Math.min(res,sub + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    //自底向上：从最初始的状态开始往上累加，直到找到最终的目标。说白了就是做加法。
    //自底向上的做法一般都是定义数组。通过迭代的方式进行构造
    public int coinChange2(int[] coins, int amount) {
        //dp数组的定义是，当目标金额为i时，至少需要dp[i]个硬币凑出结果。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        //外层for循环遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            //内层for循环求所有选择的最小值
            for (int coin : coins){
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int i = c.coinChange1(new int[]{1, 3, 5}, 11);
        System.out.println(i);
    }
}
