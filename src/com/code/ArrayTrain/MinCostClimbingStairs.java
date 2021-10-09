package com.code.ArrayTrain;

/**
 * 动态规划
 * 从顶部往底部推
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int minCost[] = new int[size];
        //状态转移方程:
        //https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
        //minCost[i] = min(minCost[i - 1] + cost[i],minCost[i - 2] + cost[i - 1])
        minCost[0] = 0;
        minCost[1] = Math.min(cost[1],cost[0]);
        for (int i = 2; i < size; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i],minCost[i - 2] + cost[i - 1]);
        }
        return minCost[size - 1];
    }

    /**
     * 优化空间
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int size = cost.length;

        //状态转移方程:
        //https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
        //minCost[i] = min(minCost[i - 1] + cost[i],minCost[i - 2] + cost[i - 1])
        int minCostA = 0;
        int minCostB = Math.min(cost[1],cost[0]);
        int temp;
        for (int i = 2; i < size; i++) {

            temp = Math.min(minCostB + cost[i],minCostA + cost[i - 1]);
            minCostA = minCostB;
            minCostB = temp;
        }
        return minCostB;
    }
}
