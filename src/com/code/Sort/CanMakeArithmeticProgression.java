package com.code.Sort;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length == 2){
            return true;
        }
        int oldValue = arr[1] - arr[0];
        for(int i=1;i < arr.length - 1;i ++){
            int newValue = arr[i + 1] - arr[i];
            if(newValue != oldValue){
                return false;
            }
        }
        return true;
    }
}
