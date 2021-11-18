package com.code.ArrayTrain;

public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                arr[i] = -1;
            }
            else{
                arr[i] = max(arr,i + 1);
            }
        }
        return arr;
    }

    public int max(int[] arr, int start){
        int max = Integer.MIN_VALUE;

        for (int i = start; i < arr.length; i++) {
            max = Math.max(arr[i],max);
        }
        return max;
    }
}
