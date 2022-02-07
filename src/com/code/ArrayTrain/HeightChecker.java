package com.code.ArrayTrain;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] excepted = new int[heights.length];
        System.arraycopy(heights,0,excepted,0,heights.length);
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (excepted[i] != heights[i]){
                count ++;
            }
        }
        return count;
    }
}
