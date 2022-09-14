package com.code.carl.dp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Change {
    public int change(int amount, int[] coins) {
        //dp[i]表示凑成总金额i的货币组合数为dp[i]
        int[] dp = new int[amount + 1];
        //凑成总金额为0的货币组合数为1
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}