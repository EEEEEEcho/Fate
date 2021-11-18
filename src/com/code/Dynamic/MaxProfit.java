package com.code.Dynamic;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;      //最大利润
        int min = prices[0];    //维护数组中的买入时最小花费
        for (int i = 1;i < prices.length;i ++){
            //如果当前价格 - 维护的最小花费 > 当前最大利润  更新最大利润
            maxProfit = Math.max(maxProfit,prices[i] - min);
            //更新最小价格
            min = Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}
