package com.code.EveryDay;

public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int count = 0;
        int zeros = 0;
        while (right < nums.length){
            if (nums[right] == 0){
                zeros ++;
            }
            right ++;
            while (zeros > k){
                if (nums[left] == 0){
                    zeros --;
                }
                left ++;
            }
            count = Math.max(right - left,count);
        }
        return count;
    }

    public static void main(String[] args) {
        LongestOnes l = new LongestOnes();
        int i = l.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        System.out.println(i);
    }
}
