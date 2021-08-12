package com.code.ArrayTrain;

import java.util.Arrays;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int total =  aliceSum + bobSum;
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if (aliceSum - aliceSizes[i] + bobSizes[j] == total / 2){
                    ans[0] = aliceSizes[i];
                    ans[1] = bobSizes[j];
                }
            }
        }
        return ans;
    }

    /**
     *  数学公式
     *  sumA - x + y = sumB - y + x
     *  x = (sumA - sumB) / 2 + y
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public int[] fairCandySwap2(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int delta = (aliceSum - bobSum) / 2;
        Arrays.sort(aliceSizes);
        for (int i = 0; i < bobSizes.length; i++) {
            int re = Arrays.binarySearch(aliceSizes, bobSizes[i] + delta);
            if (re >= 0){
                ans[0] = aliceSizes[re];
                ans[1] = bobSizes[i];
            }
        }
        return ans;
    }
}
