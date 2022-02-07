package com.code.ArrayTrain;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int zeroIndex = 0;
        while (zeroIndex < arr.length){
            if (arr[zeroIndex] == 0){
                if (zeroIndex + 1 < arr.length){
                    moveArray(arr,zeroIndex + 1);
                    arr[zeroIndex + 1] = 0;
                    zeroIndex = zeroIndex + 1;
                }
            }
            zeroIndex ++;
        }
    }
    public void moveArray(int[] arr,int start){
        for (int i = arr.length - 1;i > start; i --){
            arr[i] = arr[i - 1];
        }
    }
}
