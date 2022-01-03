package com.code.topOnehundred;

public class MaxArea {
    //超时
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right){
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max,minHeight * (right - left));
            if (height[left] > height[right]){
                right --;
            }
            else{
                left ++;
            }
        }
        return max;
    }

}
