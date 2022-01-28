package com.code.topOnehundred;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        int[] dp = new int[heights.length];
        dp[0] = heights[0];
        int minHeight = heights[0];
        int width = 1;
        for (int i = 1; i < heights.length; i++) {
            width ++;
            if (heights[i] < minHeight){
                minHeight = heights[i];
            }
            int area1 = heights[i];
            int area2 = minHeight * width;
            if (area1 > area2){
                dp[i] = area1;
                minHeight = dp[i];
                width = 1;
            }
            else{
                dp[i] = area2;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        int i = l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);


    }
}
