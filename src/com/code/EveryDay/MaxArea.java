package com.code.EveryDay;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        boolean leftChange = false;
        int right = height.length - 1;
        boolean rightChange = false;
        int maxArea = Integer.MIN_VALUE;
        while (left < right){
            int nowArea = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,nowArea);
            if (left + 1 < height.length && height[left + 1] - height[left] > 1){
                left ++;
                leftChange = true;
            }
            else{
                leftChange = false;
            }

            if (right - 1 >= 0 && height[right - 1] - height[right] > 1){
                right --;
                rightChange = true;
            }
            else{
                rightChange = false;
            }
            if (!rightChange && !leftChange){
                break;
            }
        }
        return maxArea;
    }
}
