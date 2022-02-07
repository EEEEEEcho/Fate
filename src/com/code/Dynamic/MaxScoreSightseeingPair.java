package com.code.Dynamic;

public class MaxScoreSightseeingPair {
    //这样必然是过不了的
    public int maxScoreSightseeingPair1(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1;j < values.length;j ++){
                maxScore = Math.max(maxScore,values[j] + values[i] + (i - j));
            }
        }
        return maxScore;
    }
    //因为公式是values[i] + values[j] + i - j
    //关键点是values[i] + values[j] + i - j -> values[i] + i + values[j] - j
    //只要维护好前面的values[i] + i 是前面最大的就行了
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0] + 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans,max + values[i] - i);
            max = Math.max(max,values[i] + i);
        }
        return ans;
    }
}
