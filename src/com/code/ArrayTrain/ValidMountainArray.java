package com.code.ArrayTrain;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]){
                for (int j = i; j < arr.length - 1; j++) {
                    if (arr[j + 1] < arr[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
