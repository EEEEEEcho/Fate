package com.code.Dynamic;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        //[10, 15, 20]  -> [0,0,10, 15, 20]
        int m = 0;  //dp[i - 2]
        int n = 0;  //dp[i - 1]
        for (int i = 0; i < cost.length; i++) {
            int tmp= m + cost[i];
            ans = Math.min(tmp,n);
            m = n;
            n = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs s = new MinCostClimbingStairs();
        int i = s.minCostClimbingStairs(new int[]{
                1, 100, 1, 1, 1, 100, 1, 1, 100, 1
                //10, 15, 20
        });
        System.out.println(i);
    }
}
