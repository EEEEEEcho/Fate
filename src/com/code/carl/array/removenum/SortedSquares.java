package com.code.carl.array.removenum;

import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        //单数组根本无法完成既参与排序，也接受结果
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;
        int[] ans = new int[nums.length];
        while (left <= right){
            int leftPow =(int) Math.pow(nums[left], 2);
            int rightPow = (int) Math.pow(nums[right],2);
            if (rightPow > leftPow){
                ans[pos] = rightPow;
                right --;
            }
            else{
                ans[pos] = leftPow;
                left ++;
            }
            pos --;
        }
        return ans;
    }

    public static void main(String[] args) {
        SortedSquares squares = new SortedSquares();
        int[] ints = squares.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Integer.compare(1,2));
        System.out.println(Arrays.toString(ints));
    }
}
