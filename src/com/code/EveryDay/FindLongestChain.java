package com.code.EveryDay;

import java.util.Arrays;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        //先排序
        Arrays.sort(pairs,(nums1,nums2) -> {
            if (nums1[0] != nums2[0]){
                return Integer.compare(nums1[0],nums2[0]);
            }
            else {
                return Integer.compare(nums1[1],nums2[1]);
            }
        });
        Arrays.fill(dp,1);
        //然后按照最长递增子序列的方式去求解
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
