package com.code.topOnehundred;

public class MaxArea {
    //超时
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = i; j >= 0 ; j--) {
                max = Math.max(Math.min(height[j],height[i]) * (i - j),max);
            }
        }
        return max;
    }

}
