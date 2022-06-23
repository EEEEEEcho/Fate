package com.code.EveryDay;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] tmp = new int[heights.length];
        System.arraycopy(heights, 0, tmp, 0, tmp.length);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (tmp[i] != heights[i]){
                count ++;
            }
        }
        return count;
    }
}
