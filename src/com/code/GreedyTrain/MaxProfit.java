package com.code.GreedyTrain;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        //什么叫贪心？所有正值都要，所有赋值绝对不碰
        for(int i=1;i < prices.length;i ++){
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0){
                max += tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{1,2,3,4,5}));
    }
}
