package com.code.EveryDay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSwap {
    public int maximumSwap(int num) {
        if (num % 10 == num) return num;
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = arr.length - 1; j >= i; j --) {
                if (arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }

            if (maxIndex != i){
                char tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
                return Integer.parseInt(new String(arr));
            }
        }

        return num;
    }
}
