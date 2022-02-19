package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        //先求背包的总价值
        int sum = Arrays.stream(nums).sum();
        //如果总和为奇数，肯定无法分割
        if (sum % 2 != 0){
            return false;
        }
        int weight = sum / 2;
        //给定N个物品，从N个物品中选出是否能装满weight重量
        //对于容量为 9 的背包，若只是⽤前 4 个物品，可以有⼀种⽅
        //法把背包恰好装满。
        boolean[][] dp = new boolean[nums.length + 1][weight + 1];
        //使用前i个物品能够装满重量为0的背包
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //取第i个物品
                if (j - nums[i - 1] >= 0){
                    //如果前i - 1个物品能够装满j的容量或者前i - 1个物品能够装满j - nums[i - 1]的容量(取上第i个物品)，
                    // 那么就证明，前i个物品能够装满为j的重量
                    //
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
                else{
                    //不取第i个物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    //状态压缩版本
    public boolean canPartition2(int[] nums) {
        if (nums.length == 1) return false;
        //先求背包的总价值
        int sum = Arrays.stream(nums).sum();
        //如果总和为奇数，肯定无法分割
        if (sum % 2 != 0){
            return false;
        }
        int weight = sum / 2;
        boolean[] dp = new boolean[weight + 1];
        //使用前i个物品能够装满重量为0的背包
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = weight; j >= 0 ; j--) {
                if (j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public int f(int[] weights,int w){
        int days = 0;
        int weight = w;
        for(int i = 0;i < weights.length;i ++){
            if(weight < weights[i]){
                days ++;
                weight = w;
            }
            weight -= weights[i];
        }
        return days + 1;
    }
    public static void main(String[] args) {
        CanPartition c = new CanPartition();
//        c.canPartition(new int[]{1,2,5});
        int f = c.f(new int[]{1,2,3,1,1}, 3);
        System.out.println(f);
    }
}
