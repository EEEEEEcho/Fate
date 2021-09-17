package com.code.ArrayTrain;

import java.util.Arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max){
                maxIndex = i;
            }
        }
        if (maxIndex >0 && maxIndex < arr.length && arr[maxIndex - 1] < max && arr[maxIndex + 1] < max){
            return true;
        }
        return false;
    }
}
