package com.code.Dynamic;

public class MaxProfit2 {
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        int tmpMax = 0;
        for (int i = 1;i < prices.length;i ++){
            if (prices[i] - min > 0 && prices[i] - min > tmpMax){
                tmpMax = prices[i] - min;
            }
            else{
                min = prices[i];
                maxProfit += tmpMax;
                tmpMax = 0;
                continue;
            }
            min = Math.min(min,prices[i]);
        }
        maxProfit += tmpMax;
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit2 s = new MaxProfit2();
        System.out.println(s.maxProfit2(new int[]{1,2,3,4,5}));
    }
}
