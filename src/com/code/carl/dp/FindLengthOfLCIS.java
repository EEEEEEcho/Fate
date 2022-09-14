package com.code.carl.dp;

import java.util.Arrays;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        FindLengthOfLCIS lcis = new FindLengthOfLCIS();
        lcis.findLengthOfLCIS(new int[]{1,3,5,4,7});
    }
}
